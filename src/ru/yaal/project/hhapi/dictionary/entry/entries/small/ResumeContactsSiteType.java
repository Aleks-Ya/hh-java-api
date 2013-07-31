package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Тип сайта в поле «контакты» (резюме).
 */
public final class ResumeContactsSiteType extends AbstractDictionaryEntry {
    public static final ResumeContactsSiteType NULL_RESUME_CONTACTS_SITE_TYPE = new ResumeContactsSiteType();
    public static final IDictionary<ResumeContactsSiteType> RESUME_CONTACTS_SITE_TYPES
            = SmallDictionariesInitializer.getInstance().getResumeContactsSiteType();
    /**
     * Другой сайт.
     */
    public static final ResumeContactsSiteType PERSONAL = RESUME_CONTACTS_SITE_TYPES.getById("personal");
    /**
     * Мой круг.
     */
    public static final ResumeContactsSiteType MOI_KRUG = RESUME_CONTACTS_SITE_TYPES.getById("moi_krug");
    /**
     * LiveJournal.
     */
    public static final ResumeContactsSiteType LIVEJOURNAL = RESUME_CONTACTS_SITE_TYPES.getById("livejournal");
    /**
     * LinkedIn.
     */
    public static final ResumeContactsSiteType LINKEDIN = RESUME_CONTACTS_SITE_TYPES.getById("linkedin");
    /**
     * Free-lance.
     */
    public static final ResumeContactsSiteType FREELANCE = RESUME_CONTACTS_SITE_TYPES.getById("freelance");
    /**
     * Facebook.
     */
    public static final ResumeContactsSiteType FACEBOOK = RESUME_CONTACTS_SITE_TYPES.getById("facebook");
    /**
     * Skype.
     */
    public static final ResumeContactsSiteType SKYPE = RESUME_CONTACTS_SITE_TYPES.getById("skype");
    /**
     * ICQ.
     */
    public static final ResumeContactsSiteType ICQ = RESUME_CONTACTS_SITE_TYPES.getById("icq");
    /**
     * Jabber.
     */
    public static final ResumeContactsSiteType JABBER = RESUME_CONTACTS_SITE_TYPES.getById("jabber");

    private ResumeContactsSiteType() {
    }
}
