package ru.yaal.project.hhapi.dictionary.entry.entries.simple;

import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

public class Gender extends AbstractDictionaryEntry {
    public static final Gender NULL_GENDER = new Gender();
    public static final IDictionary<Gender> GENDERS = Dictionaries.getInstance().getGender();
    public static final Gender UNKNOWN = GENDERS.getById("unknown");
    public static final Gender MALE = GENDERS.getById("male");
    public static final Gender FEMALE = GENDERS.getById("female");
}
