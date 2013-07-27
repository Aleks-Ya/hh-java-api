package ru.yaal.project.hhapi.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.loader.storage.FileStorage;
import ru.yaal.project.hhapi.loader.storage.IStorage;
import ru.yaal.project.hhapi.loader.storage.MemoryStorage;
import ru.yaal.project.hhapi.loader.storage.TwoLevelStorage;

import java.io.File;

public class ContentLoaderFactory {
    private static final Logger LOG = LoggerFactory.getLogger(ContentLoaderFactory.class);
    private static final IStorage longTermStorage;
    private static final IStorage shortTermStorage;
    private static IStorage fakeStorage;

    static {
        File longTermDir = new File(System.getProperty("java.io.tmpdir") + "hh_api_cache\\long_term\\");
        if (!longTermDir.exists()) longTermDir.mkdirs();
        int sevenDays = 7 * 24 * 60;
        longTermStorage = new TwoLevelStorage(new MemoryStorage(sevenDays), new FileStorage(longTermDir, sevenDays));
        LOG.info("Кэш длительного хранения ({} мин.): {}", sevenDays, longTermDir.getAbsolutePath());

        File shortTermDir = new File(System.getProperty("java.io.tmpdir") + "hh_api_cache\\short_term\\");
        if (!shortTermDir.exists()) shortTermDir.mkdirs();
        int oneDay = 24 * 60;
        shortTermStorage = new TwoLevelStorage(new MemoryStorage(oneDay), new FileStorage(shortTermDir, oneDay));
        LOG.info("Кэш краткосрочного хранения ({} мин.): {}", oneDay, shortTermDir.getAbsolutePath());

        if (isUseFakeStorage()) {
            fakeStorage = getFakeStorage();
        }
        LOG.info("Кэш для тестирования: {}", fakeStorage);
    }

    public static IContentLoader newInstanceLongTermCache() {
        IStorage storage = (fakeStorage == null) ? longTermStorage : fakeStorage;
        return new ContentLoader(storage);
    }

    public static IContentLoader newInstanceSortTermCache() {
        IStorage storage = (fakeStorage == null) ? shortTermStorage : fakeStorage;
        return new ContentLoader(storage);
    }

    private static IStorage getFakeStorage() {
        if (isUseFakeStorage()) {
            try {
                Class fakeStorageClass = Class.forName("ru.yaal.project.hhapi.loader.storage.ClassResourceStorage");
                return (IStorage) fakeStorageClass.newInstance();
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return null;
    }

    private static boolean isUseFakeStorage() {
        return Boolean.valueOf(System.getProperty("use_fake_storage"));
    }
}
