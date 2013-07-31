package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Уровень доступа к резюме (резюме).
 */
public class ResumeAccessType extends AbstractDictionaryEntry {
    public static final ResumeAccessType NULL_RESUME_ACCESS_TYPE = new ResumeAccessType();
    public static final IDictionary<ResumeAccessType> RESUME_ACCESS_TYPES = SmallDictionariesInitializer.getInstance().getResumeAccessType();
    /**
     * Закрытое (резюме не видно никому).
     */
    public static final ResumeAccessType NO_ONE = RESUME_ACCESS_TYPES.getById("no_one");
    /**
     * Резюме видно только выбранным компаниям.
     */
    public static final ResumeAccessType WHITE_LIST = RESUME_ACCESS_TYPES.getById("whitelist");
    /**
     * Все компании, кроме выбранных (список в настройках видимости).
     */
    public static final ResumeAccessType BLACK_LIST = RESUME_ACCESS_TYPES.getById("blacklist");
    /**
     * Видят только клиенты hh.ru.
     */
    public static final ResumeAccessType CLIENTS = RESUME_ACCESS_TYPES.getById("clients");
    /**
     * Видно всему интернету.
     */
    public static final ResumeAccessType EVERYONE = RESUME_ACCESS_TYPES.getById("everyone");
    /**
     * Резюме видно только по прямой ссылке.
     */
    public static final ResumeAccessType DIRECT = RESUME_ACCESS_TYPES.getById("direct");

    private ResumeAccessType() {
    }
}
