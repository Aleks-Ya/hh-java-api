package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * язык сайта.
 * @see ru.yaal.project.hhapi.dictionary.Constants.SiteLang
 */
public final class SiteLang extends AbstractDictionaryEntry {
    public static final SiteLang NULL_SITE_LANG = new SiteLang();

    private SiteLang() {
    }
}
