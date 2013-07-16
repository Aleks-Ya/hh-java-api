package ru.yaal.project.hhapi.dictionary.entry.entries.simple;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

public class Gender extends AbstractDictionaryEntry {
    public static final Gender NULL_GENDER = new Gender();
    public static final Gender UNKNOWN = new Gender("unknown", "Не скажу");
    public static final Gender MALE = new Gender("male", "Мужской");
    public static final Gender FEMALE = new Gender("female", "Женский");

    public Gender() {
    }

    public Gender(String id, String name) {
        setId(id);
        setName(name);
    }

}
