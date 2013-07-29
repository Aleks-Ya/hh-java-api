package ru.yaal.project.hhapi.loader.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Date;

public abstract class AbstractStorage implements IStorage {
    protected static final String DATA_FOUND_MESSAGE = "Данные для url={} в кэше найдены. Размер: {}.";
    protected static final String DATA_FOUND_BUT_EMPTY_MESSAGE = "Данные для url={} в кэше найдены, но они пустые.";
    protected static final String DATA_FOUND_BUT_OUTDATED_MESSAGE = "Данные для url={} в кэше найдены, но они устарели. Удаляю.";
    protected static final String DATA_NOT_FOUND_MESSAGE = "Данные для url={} кэше не найдены.";
    protected static final String SAVE_DATA_MESSAGE = "Сохраняю в кэш данные для url={} (длина контента {}).";
    private static final Logger LOG = LoggerFactory.getLogger(AbstractStorage.class);
    private long lifeTimeMilliSec;

    public AbstractStorage(int lifeTimeMin) {
        this.lifeTimeMilliSec = lifeTimeMin * 60 * 1000;
        assert (lifeTimeMilliSec >= 0);
    }

    protected String generateHashFileName(String realFileName) {
        int hashCode = realFileName.hashCode();
        return "cache_" + hashCode + ".json";
    }

    protected boolean isOutdated(long createDate, long lifeTimeMilliSec) {
        long now = new Date().getTime();
        long outdated = createDate + lifeTimeMilliSec;
        return now > outdated;
    }

    protected String verifyContent(String name, String content, long lastModified) {
        if (content != null) {
            if (!isOutdated(lastModified, lifeTimeMilliSec)) {
                LOG.info(DATA_FOUND_MESSAGE, name, content.length());
                if (!content.isEmpty()) {
                    return content;
                } else {
                    LOG.info(DATA_FOUND_BUT_EMPTY_MESSAGE, name);
                    return null;
                }
            } else {
                LOG.info(DATA_FOUND_BUT_OUTDATED_MESSAGE, name);
                delete(name);
                return null;
            }
        } else {
            LOG.info(DATA_NOT_FOUND_MESSAGE, name);
            return null;
        }
    }

    protected String loadFromFile(File file) {
        try {
            if (file.exists()) {
                LineNumberReader reader = new LineNumberReader(new FileReader(file));
                StringBuilder builder = new StringBuilder();
                String s;
                while ((s = reader.readLine()) != null) {
                    builder.append(s);
                }
                reader.close();
                return builder.toString().trim();
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }
}
