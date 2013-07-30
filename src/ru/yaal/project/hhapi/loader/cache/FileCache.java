package ru.yaal.project.hhapi.loader.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.String.format;

public class FileCache extends AbstractCache {
    private static final Logger LOG = LoggerFactory.getLogger(FileCache.class);
    private static final String DEFAULT_NAME = "File Storage";
    private final File dir;

    public FileCache(File dir, int lifeTimeMin) {
        this(DEFAULT_NAME, dir, lifeTimeMin);
    }

    public FileCache(String name, File dir, int lifeTimeMin) {
        super(name, lifeTimeMin);
        this.dir = dir;
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    @Override
    public String search(String name) {
        String hash = generateHashFileName(name);
        File file = new File(dir, hash);
        if (file.exists()) {
            long lastModified = file.lastModified();
            String content = loadFromFile(file);
            return verifyContent(name, content, lastModified);
        } else {
            return null;
        }
    }

    @Override
    public void save(String name, String content) {
        try {
            LOG.info(SAVE_DATA_MESSAGE, name, content.length());
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
        if (file.exists()) {
            file.delete();
        }
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

}
