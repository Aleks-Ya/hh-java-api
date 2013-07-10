package ru.yaal.project.hhapi.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Загруажет контент с адресов, доступных без авторизации.
 * 
 * @author Aleks
 * 
 */
public class ContentLoader implements IContentLoader {
	protected final Map<String, String> parameters = new HashMap<>();

	public String loadContent(final String url) throws LoadException {
		try {
			assert (url != null);
			URL hhUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) hhUrl
					.openConnection();
			connection.setRequestMethod("GET");
			for (String key : parameters.keySet()) {
				connection.addRequestProperty(key, parameters.get(key));
			}
			connection.connect();
			String content = readInputStreamToString(connection);
			connection.disconnect();
			return content;
		} catch (Exception e) {
			throw new LoadException(e);
		}
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
		parameters.put(key, value);
	}
}
