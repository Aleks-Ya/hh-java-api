package ru.yaal.project.hhapi.dictionary.entry.entries.simple;

import ru.yaal.project.hhapi.dictionary.Dictionaries2;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

public class Gender extends AbstractDictionaryEntry {
    public static final Gender NULL_GENDER = new Gender();
    public static final Gender UNKNOWN = Dictionaries2.getInstance().getGender().getById("unknown");
    public static final Gender MALE = Dictionaries2.getInstance().getGender().getById("male");
    public static final Gender FEMALE = Dictionaries2.getInstance().getGender().getById("female");
}
