package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * ������� �������� ������ (������).
 */
public final class LanguageLevel extends AbstractDictionaryEntry {
    public static final LanguageLevel NULL_LANGUAGE_LEVEL = new LanguageLevel();
    public static final IDictionary<LanguageLevel> LANGUAGE_LEVELS = SmallDictionariesInitializer.getInstance().getLanguageLevel();
    /**
     * ������� ������.
     */
    public static final LanguageLevel BASIC = LANGUAGE_LEVELS.getById("basic");
    /**
     * ����� ���������������� ����������.
     */
    public static final LanguageLevel CAN_READ = LANGUAGE_LEVELS.getById("can_read");
    /**
     * ���� ��������� ��������.
     */
    public static final LanguageLevel CAN_PASS_INTERVIEW = LANGUAGE_LEVELS.getById("can_pass_interview");
    /**
     * �������� ������.
     */
    public static final LanguageLevel FLUENT = LANGUAGE_LEVELS.getById("fluent");
    /**
     * ������.
     */
    public static final LanguageLevel NATIVE = LANGUAGE_LEVELS.getById("native");

    private LanguageLevel() {
    }

}
