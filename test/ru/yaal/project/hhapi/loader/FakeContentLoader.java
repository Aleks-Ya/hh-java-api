package ru.yaal.project.hhapi.loader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

public class FakeContentLoader implements IContentLoader {

    @Override
    public String loadContent(String url) throws LoadException {
        try {
            switch (url) {
                case UrlConstants.DICTINARIES_URL: {
                    return getResource("dictionaries.json", UrlConstants.DICTINARIES_URL);
                }
                case UrlConstants.AREAS_URL: {
                    return getResource("areas.json", UrlConstants.AREAS_URL);
                }
                case UrlConstants.SPECIALIZATIONS_URL: {
                    return getResource("specializations.json", UrlConstants.SPECIALIZATIONS_URL);
                }
                case UrlConstants.VACANCIES_URL: {
                    return getResource("vacancies.json", UrlConstants.VACANCIES_URL);
                }
                case UrlConstants.METRO_URL: {
                    return getResource("metro.json", UrlConstants.METRO_URL);
                }
                default: {
                    throw new RuntimeException("Неопознанный url для загрузки контента: " + url);
                }
            }
        } catch (Exception e) {
            throw new LoadException(e);
        }
    }

    @Override
    public void addHeader(String key, String value) {
        //не используется
    }

    private String getResource(String resourceName, String url) throws IOException, LoadException {
        String fileContent = loadResource(resourceName);
        if (!fileContent.isEmpty()) {
            return fileContent;
        } else {
            IContentLoader realLoader = new ContentLoader();
            String realContent = realLoader.loadContent(url);
            saveResource(resourceName, realContent);
            return realContent;
        }
    }

    private String loadResource(String resourceName) throws IOException {
        String resource = FakeContentLoader.class.getResource(resourceName).getFile();
        LineNumberReader reader = new LineNumberReader(new FileReader(resource));
        StringBuilder builder = new StringBuilder();
        String s;
        while ((s = reader.readLine()) != null) builder.append(s);
        reader.close();
        return builder.toString().trim();
    }

    private void saveResource(String resourceName, String content) throws IOException {
        String resource = FakeContentLoader.class.getResource(resourceName).getFile();
        FileWriter writer = new FileWriter(resource);
        writer.append(content);
        writer.close();
    }

    @Override
    public void addParam(String key, String value) {
        throw new UnsupportedOperationException();
    }
}
