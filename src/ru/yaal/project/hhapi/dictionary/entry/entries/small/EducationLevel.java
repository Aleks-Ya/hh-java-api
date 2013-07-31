package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Образование (резюме).
 */
public final class EducationLevel extends AbstractDictionaryEntry {
    public static final EducationLevel NULL_EDUCATION_LEVEL = new EducationLevel();
    public static final IDictionary<EducationLevel> EDUCATION_LEVELS = SmallDictionariesInitializer.getInstance().getEducationLevel();
    /**
     * Высшее.
     */
    public static final EducationLevel HIGHER = EDUCATION_LEVELS.getById("higher");
    /**
     * Бакалавр.
     */
    public static final EducationLevel BACHELOR = EDUCATION_LEVELS.getById("bachelor");
    /**
     * Магистр.
     */
    public static final EducationLevel MASTER = EDUCATION_LEVELS.getById("master");
    /**
     * Кандидат наук.
     */
    public static final EducationLevel CANDIDATE = EDUCATION_LEVELS.getById("candidate");
    /**
     * Доктор наук.
     */
    public static final EducationLevel DOCTOR = EDUCATION_LEVELS.getById("doctor");
    /**
     * Неоконченное высшее.
     */
    public static final EducationLevel UNFINISHED_HIGHER = EDUCATION_LEVELS.getById("unfinished_higher");
    /**
     * Среднее.
     */
    public static final EducationLevel SECONDARY = EDUCATION_LEVELS.getById("secondary");
    /**
     * Среднее специальное.
     */
    public static final EducationLevel SPECIAL_SECONDARY = EDUCATION_LEVELS.getById("special_secondary");

    private EducationLevel() {
    }

}
