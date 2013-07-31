package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Уровень владения языком (резюме).
 */
public final class LanguageLevel extends AbstractDictionaryEntry {
    public static final LanguageLevel NULL_LANGUAGE_LEVEL = new LanguageLevel();
    public static final IDictionary<LanguageLevel> LANGUAGE_LEVELS = SmallDictionariesInitializer.getInstance().getLanguageLevel();
    /**
     * Базовые знания.
     */
    public static final LanguageLevel BASIC = LANGUAGE_LEVELS.getById("basic");
    /**
     * Читаю профессиональную литературу.
     */
    public static final LanguageLevel CAN_READ = LANGUAGE_LEVELS.getById("can_read");
    /**
     * Могу проходить интервью.
     */
    public static final LanguageLevel CAN_PASS_INTERVIEW = LANGUAGE_LEVELS.getById("can_pass_interview");
    /**
     * Свободно владею.
     */
    public static final LanguageLevel FLUENT = LANGUAGE_LEVELS.getById("fluent");
    /**
     * Родной.
     */
    public static final LanguageLevel NATIVE = LANGUAGE_LEVELS.getById("native");

    private LanguageLevel() {
    }

}
