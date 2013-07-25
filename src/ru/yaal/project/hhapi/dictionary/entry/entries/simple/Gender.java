package ru.yaal.project.hhapi.dictionary.entry.entries.simple;

import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

public class Gender extends AbstractDictionaryEntry {
    public static final Gender NULL_GENDER = new Gender();
    public static final Gender UNKNOWN = Dictionaries.getGender().getById("unknown");
    public static final Gender MALE = Dictionaries.getGender().getById("male");
    public static final Gender FEMALE = Dictionaries.getGender().getById("female");
}
