package ru.yaal.project.hhapi.dictionary.entry.entries.simple;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

public class Employment extends AbstractDictionaryEntry {
    public static final Employment NULL_EMPLOYMENT = new Employment();
    public static final Employment FULL = new Employment("full", "Полная занятость");
    public static final Employment PART = new Employment("part", "Частичная занятость");
    public static final Employment PROJECT = new Employment("project", "Проектная работа");
    public static final Employment VOLUNTEER = new Employment("volunteer", "Волонтерство");
    public static final Employment PROBATION = new Employment("probation", "Стажировка");

    public Employment() {
    }

    public Employment(String id, String name) {
        super(id, name);
    }

}
