package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * ����������� (������).
 */
public final class EducationLevel extends AbstractDictionaryEntry {
    public static final EducationLevel NULL_EDUCATION_LEVEL = new EducationLevel();
    public static final IDictionary<EducationLevel> EDUCATION_LEVELS = SmallDictionariesInitializer.getInstance().getEducationLevel();
    /**
     * ������.
     */
    public static final EducationLevel HIGHER = EDUCATION_LEVELS.getById("higher");
    /**
     * ��������.
     */
    public static final EducationLevel BACHELOR = EDUCATION_LEVELS.getById("bachelor");
    /**
     * �������.
     */
    public static final EducationLevel MASTER = EDUCATION_LEVELS.getById("master");
    /**
     * �������� ����.
     */
    public static final EducationLevel CANDIDATE = EDUCATION_LEVELS.getById("candidate");
    /**
     * ������ ����.
     */
    public static final EducationLevel DOCTOR = EDUCATION_LEVELS.getById("doctor");
    /**
     * ������������ ������.
     */
    public static final EducationLevel UNFINISHED_HIGHER = EDUCATION_LEVELS.getById("unfinished_higher");
    /**
     * �������.
     */
    public static final EducationLevel SECONDARY = EDUCATION_LEVELS.getById("secondary");
    /**
     * ������� �����������.
     */
    public static final EducationLevel SPECIAL_SECONDARY = EDUCATION_LEVELS.getById("special_secondary");

    private EducationLevel() {
    }

}
