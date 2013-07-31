package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * язык сайта.
 */
public final class SiteLang extends AbstractDictionaryEntry {
    public static final SiteLang NULL_SITE_LANG = new SiteLang();
    public static final IDictionary<SiteLang> SITE_LANGS = SmallDictionariesInitializer.getInstance().getSiteLang();
    /**
     * ѕо-русски.
     */
    public static final SiteLang RU = SITE_LANGS.getById("ru");
    /**
     * In English.
     */
    public static final SiteLang EN = SITE_LANGS.getById("en");

    private SiteLang() {
    }
}
