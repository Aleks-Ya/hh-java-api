package ru.yaal.project.hhapi.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

/**
 * ��������� ������� � �������, ��������� ��� �����������.
 *
 * @author Aleks
 */
public class ContentLoader implements IContentLoader {
    private static final Logger LOG = LoggerFactory.getLogger(ContentLoader.class);
    protected final Map<String, String> headers = new HashMap<>();
    protected final Map<String, List<String>> params = new HashMap<>();

    public String loadContent(String url) throws LoadException {
        try {
            LOG.info("�������� ������ � {}.", url);
            assert (url != null);
            url = setParameters(url);
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
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new LoadException(e);
        }
    }

    private String setParameters(String url) throws URISyntaxException {
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
