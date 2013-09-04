package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Тип сайта в поле «контакты» (резюме).
 * @see ru.yaal.project.hhapi.dictionary.Constants.ResumeContactsSiteType
 */
public final class ResumeContactsSiteType extends AbstractDictionaryEntry {
    public static final ResumeContactsSiteType NULL_RESUME_CONTACTS_SITE_TYPE = new ResumeContactsSiteType();

    private ResumeContactsSiteType() {
    }
}
