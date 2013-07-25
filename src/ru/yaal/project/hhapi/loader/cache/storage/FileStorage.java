package ru.yaal.project.hhapi.loader.cache.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Date;

import static java.lang.String.format;

public class FileStorage implements IStorage {
    private static final Logger LOG = LoggerFactory.getLogger(FileStorage.class);
    private final File dir;
    private final int lifeTimeSec;

    public FileStorage(File dir, int lifeTimeSec) {
        this.dir = dir;
        this.lifeTimeSec = lifeTimeSec;
        if (!dir.exists()) dir.mkdirs();
    }

    @Override
    public String search(String name) {
        String hash = generateHashFileName(name);
        File file = new File(dir, hash);
        if (file.exists()) {
            long lastModified = file.lastModified();
            Date now = new Date();
            Date outdated = new Date(lastModified + lifeTimeSec * 1000);
            if (outdated.after(now)) {
                String content = loadFromFile(file);
                if (content != null && !content.isEmpty()) {
                    LOG.info("Данные для url={} в кэше найдены. Размер: {}.", name, content.length());
                    return content;
                } else {
                    LOG.warn("Файл для url={} в кэше найден, но он пустой.", name);
                    return null;
                }
            } else {
                LOG.info("Данные для url={} в кэше найдены, но они устарели. Удаляю.", name);
                delete(name);
                return null;
            }
        } else {
            LOG.info("Данные для url={} кэше не найдены.", name);
            return null;
        }

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

    @Override
    public void save(String name, String content) {
        try {
            LOG.info("Сохраняю в кэш данные для url={} (длина контента {}).", name, content.length());
            String hashFileName = generateHashFileName(name);
            File file = new File(dir, hashFileName);
            FileWriter writer = new FileWriter(file);
            writer.append(content);
            writer.close();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public void delete(String name) {
        String hash = generateHashFileName(name);
        File file = new File(dir, hash);
        if (file.exists()) file.delete();
    }

    @Override
    public void clear() {
        if (dir.exists()) {
            File[] nestedFiles = dir.listFiles();
            for (File nestedFile : nestedFiles) {
                nestedFile.delete();
            }
            if (dir.list().length > 0) {
                RuntimeException e = new RuntimeException(format("Не удалось очистить кэш %s.", dir.getAbsolutePath()));
                LOG.error(e.getMessage());
                throw e;
            }
        }
    }

    private String generateHashFileName(String realFileName) {
        int hashCode = realFileName.hashCode();
        return "cache_" + hashCode + ".json";
    }
}
