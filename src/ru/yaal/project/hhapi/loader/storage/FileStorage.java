package ru.yaal.project.hhapi.loader.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

import static java.lang.String.format;

public class FileStorage extends AbstractStorage {
    private static final Logger LOG = LoggerFactory.getLogger(FileStorage.class);
    private final File dir;

    public FileStorage(File dir, int lifeTimeMin) {
        super(lifeTimeMin);
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
