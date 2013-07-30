package ru.yaal.project.hhapi.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.loader.cache.ICache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * Загруажет контент с адресов, доступных без авторизации.
 *
 * @author Aleks
 */
class ContentLoader implements IContentLoader {
    private static final Logger LOG = LoggerFactory.getLogger(ContentLoader.class);
    private final Map<String, String> headers = new HashMap<>();
    private final Map<String, List<String>> params = new HashMap<>();
    private final ICache storage;

    ContentLoader(ICache storage) {
        this.storage = storage;
    }

    public String loadContent(String url) throws LoadException {
        try {
            assert (url != null);
            String urlWithParams = appendParameters(url);
            String cachedContent = storage.search(urlWithParams);
            if (cachedContent != null && !cachedContent.isEmpty()) {
                return cachedContent;
            } else {
                String content = loadContentFromNet(urlWithParams);
                storage.save(urlWithParams, content);
                return content;
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new LoadException(e);
        }
    }

    private String loadContentFromNet(String url) throws IOException {
        LOG.info("Загружаю данные с {}.", url);
        URL hhUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) hhUrl.openConnection();
        connection.setRequestMethod("GET");
        addHeader("User-Agent", "HhJavaApi/1.0 (ya_al@bk.ru)");
        addHeader("Accept", "application/json");
        setHeaders(connection);
        connection.connect();
        String content = readInputStreamToString(connection);
        connection.disconnect();
        return content;
    }

    protected String appendParameters(String url) {
        StringBuilder builder = new StringBuilder(url);
        for (String key : params.keySet()) {
            for (String value : params.get(key)) {
                if (builder.indexOf("?") == -1) {
                    builder.append("?");
                } else {
                    builder.append("&");
                }
                builder.append(key);
                builder.append("=");
                builder.append(value);
            }
        }
        return builder.toString();
    }

    private void setHeaders(HttpURLConnection connection) {
        for (String key : headers.keySet()) {
            connection.setRequestProperty(key, headers.get(key));
        }
    }

    @Override
    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    private String readInputStreamToString(HttpURLConnection conn)
            throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                conn.getInputStream(), "UTF-8"));
        StringBuilder builder = new StringBuilder();
        while (true) {
            String line = reader.readLine();
            if (line != null) {
                builder.append(line);
            } else {
                break;
            }
        }
        return builder.toString();
    }

    @Override
    public void addParam(String key, String value) {
        if (!params.containsKey(key)) {
            params.put(key, new ArrayList<>(Arrays.asList(value)));
        } else {
            List<String> values = params.get(key);
            values.add(value);
        }
    }
}
