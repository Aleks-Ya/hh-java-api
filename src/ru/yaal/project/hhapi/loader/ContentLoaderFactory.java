package ru.yaal.project.hhapi.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.loader.cache.*;

import java.io.File;

public final class ContentLoaderFactory {
    public static final String JAVA_IO_TMPDIR = System.getProperty("java.io.tmpdir");
    private static final Logger LOG = LoggerFactory.getLogger(ContentLoaderFactory.class);
    private static final ICache LONG_TERM_STORAGE;
    private static final ICache SHORT_TERM_STORAGE;
    private static ICache fakeStorage;

    static {
        final String cacheDir = JAVA_IO_TMPDIR + "hh_api_cache\\";

        int sevenDays = 7 * 24 * 60;
        File longTermDir = new File(cacheDir + "long_term\\");
        LONG_TERM_STORAGE = new TwoLevelCache(new MemoryCache(sevenDays), new FileCache(longTermDir, sevenDays));
        LOG.info("Инициализирован кэш длительного хранения ({} мин.): {}", sevenDays, longTermDir.getAbsolutePath());

        int oneDay = 24 * 60;
        File shortTermDir = new File(cacheDir + "short_term\\");
        SHORT_TERM_STORAGE = new TwoLevelCache(new MemoryCache(oneDay), new FileCache(shortTermDir, oneDay));
        LOG.info("Инициализирован кэш краткосрочного хранения ({} мин.): {}", oneDay, shortTermDir.getAbsolutePath());

        if (isUseFakeStorage()) {
            File testCacheDir = new File(cacheDir + "test\\");
            fakeStorage = new ClassResourceCache(testCacheDir);
        }
        LOG.info("Инициализирован кэш для тестирования: {}", fakeStorage);
    }

    private ContentLoaderFactory() {
    }

    public static IContentLoader newInstanceLongTermCache() {
        ICache storage = (fakeStorage == null) ? LONG_TERM_STORAGE : fakeStorage;
        return new ContentLoader(storage);
    }

    public static IContentLoader newInstanceSortTermCache() {
        ICache storage = (fakeStorage == null) ? SHORT_TERM_STORAGE : fakeStorage;
        return new ContentLoader(storage);
    }

    private static boolean isUseFakeStorage() {
        return Boolean.valueOf(System.getProperty("use_test_cache"));
    }
}