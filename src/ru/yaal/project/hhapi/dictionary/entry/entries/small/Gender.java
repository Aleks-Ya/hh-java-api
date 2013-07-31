package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Пол (резюме).
 */
public class Gender extends AbstractDictionaryEntry {
    public static final Gender NULL_GENDER = new Gender();
    public static final IDictionary<Gender> GENDERS = SmallDictionariesInitializer.getInstance().getGender();
    /**
     * Не скажу.
     */
    public static final Gender UNKNOWN = GENDERS.getById("unknown");
    /**
     * Мужской.
     */
    public static final Gender MALE = GENDERS.getById("male");
    /**
     * Женский.
     */
    public static final Gender FEMALE = GENDERS.getById("female");

    private Gender() {
    }
}
