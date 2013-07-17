package ru.yaal.project.hhapi.dictionary.entry.entries.simple;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

public class Employment extends AbstractDictionaryEntry {
    public static final Employment NULL_EMPLOYMENT = new Employment();
    public static final Employment FULL = new Employment("full", "������ ���������");
    public static final Employment PART = new Employment("part", "��������� ���������");
    public static final Employment PROJECT = new Employment("project", "��������� ������");
    public static final Employment VOLUNTEER = new Employment("volunteer", "������������");
    public static final Employment PROBATION = new Employment("probation", "����������");

    public Employment() {
    }

    public Employment(String id, String name) {
        super(id, name);
    }

}
