package ru.yaal.project.hhapi.loader.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.loader.LoadException;

import java.io.*;
import java.net.URL;

public class CacheDriver {
    private static final Logger LOG = LoggerFactory.getLogger(CacheDriver.class);
    private File tempDir;

    public CacheDriver() throws LoadException {
        tempDir = new File(System.getProperty("java.io.tmpdir") + "hh_api_cache\\");
        if (!tempDir.exists()) tempDir.mkdirs();
    }

    public String searchContent(String resourceName) {
        String hash = generateHashFileName(resourceName);
        String content = loadFromCache(hash);
        if (content == null) {
            content = loadFromTemp(hash);
        }
        LOG.info("Данные для url={} в кэше найдены: {}.", resourceName, content != null);
        return content;
    }

    private String loadFromCache(String resourceName) {
        URL resourceUrl = CacheDriver.class.getResource(resourceName);
        if (resourceUrl != null) {
            File resource = new File(CacheDriver.class.getResource(resourceName).getFile());
            return loadFromFile(resource);
        } else {
            return null;
        }
    }

    private String loadFromTemp(String hash) {
        return loadFromFile(new File(tempDir, hash));
    }

    private String loadFromFile(File file) {
        try {
            if (file.exists()) {
                LineNumberReader reader = new LineNumberReader(new FileReader(file));
                StringBuilder builder = new StringBuilder();
                String s;
                while ((s = reader.readLine()) != null) builder.append(s);
                reader.close();
                return builder.toString().trim();
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

    public void saveContent(String url, String content) throws LoadException {
        try {
            LOG.info("Сохраняю в кэш данные для url={} (длина контента {}).", url, content.length());
            String hashFileName = generateHashFileName(url);
            File file = new File(tempDir, hashFileName);
            FileWriter writer = new FileWriter(file);
            writer.append(content);
            writer.close();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new LoadException(e);
        }
    }

    private String generateHashFileName(String realFileName) {
        int hashCode = realFileName.hashCode();
        return "cache_" + hashCode + ".json";
    }

    public boolean clearTempCache() {
        if (tempDir.exists()) {
            File[] nestedFiles = tempDir.listFiles();
            for (File nestedFile : nestedFiles) {
                nestedFile.delete();
            }
        }
        return (tempDir.exists());
    }

    public boolean deleteFromTempCache(String url) {
        String hash = generateHashFileName(url);
        File file = new File(tempDir, hash);
        if (file.exists()) file.delete();
        return !file.exists();
    }
}
