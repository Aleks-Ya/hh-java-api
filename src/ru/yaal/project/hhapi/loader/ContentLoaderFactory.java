package ru.yaal.project.hhapi.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.loader.cache.*;

import java.io.File;

public class ContentLoaderFactory {
    private static final Logger LOG = LoggerFactory.getLogger(ContentLoaderFactory.class);
    private static final ICache longTermStorage;
    private static final ICache shortTermStorage;
    private static ICache fakeStorage;

    static {
        File longTermDir = new File(System.getProperty("java.io.tmpdir") + "hh_api_cache\\long_term\\");
        if (!longTermDir.exists()) {
            longTermDir.mkdirs();
        }
        int sevenDays = 7 * 24 * 60;
        longTermStorage = new TwoLevelCache(new MemoryCache(sevenDays), new FileCache(longTermDir, sevenDays));
        LOG.info("Кэш длительного хранения ({} мин.): {}", sevenDays, longTermDir.getAbsolutePath());

        File shortTermDir = new File(System.getProperty("java.io.tmpdir") + "hh_api_cache\\short_term\\");
        if (!shortTermDir.exists()) {
            shortTermDir.mkdirs();
        }
        int oneDay = 24 * 60;
        shortTermStorage = new TwoLevelCache(new MemoryCache(oneDay), new FileCache(shortTermDir, oneDay));
        LOG.info("Кэш краткосрочного хранения ({} мин.): {}", oneDay, shortTermDir.getAbsolutePath());

        if (isUseFakeStorage()) {
            File testDir = new File(System.getProperty("java.io.tmpdir") + "hh_api_cache\\test\\");
            if (!longTermDir.exists()) {
                longTermDir.mkdirs();
            }
            fakeStorage = new ClassResourceCache(testDir);
        }
        LOG.info("Кэш для тестирования: {}", fakeStorage);
    }

    public static IContentLoader newInstanceLongTermCache() {
        ICache storage = (fakeStorage == null) ? longTermStorage : fakeStorage;
        return new ContentLoader(storage);
    }

    public static IContentLoader newInstanceSortTermCache() {
        ICache storage = (fakeStorage == null) ? shortTermStorage : fakeStorage;
        return new ContentLoader(storage);
    }

    private static boolean isUseFakeStorage() {
        return Boolean.valueOf(System.getProperty("use_fake_storage"));
    }
}
