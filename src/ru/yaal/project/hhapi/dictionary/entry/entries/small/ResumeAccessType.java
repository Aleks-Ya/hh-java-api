package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * ������� ������� � ������ (������).
 */
public class ResumeAccessType extends AbstractDictionaryEntry {
    public static final ResumeAccessType NULL_RESUME_ACCESS_TYPE = new ResumeAccessType();
    public static final IDictionary<ResumeAccessType> RESUME_ACCESS_TYPES = SmallDictionariesInitializer.getInstance().getResumeAccessType();
    /**
     * �������� (������ �� ����� ������).
     */
    public static final ResumeAccessType NO_ONE = RESUME_ACCESS_TYPES.getById("no_one");
    /**
     * ������ ����� ������ ��������� ���������.
     */
    public static final ResumeAccessType WHITE_LIST = RESUME_ACCESS_TYPES.getById("whitelist");
    /**
     * ��� ��������, ����� ��������� (������ � ���������� ���������).
     */
    public static final ResumeAccessType BLACK_LIST = RESUME_ACCESS_TYPES.getById("blacklist");
    /**
     * ����� ������ ������� hh.ru.
     */
    public static final ResumeAccessType CLIENTS = RESUME_ACCESS_TYPES.getById("clients");
    /**
     * ����� ����� ���������.
     */
    public static final ResumeAccessType EVERYONE = RESUME_ACCESS_TYPES.getById("everyone");
    /**
     * ������ ����� ������ �� ������ ������.
     */
    public static final ResumeAccessType DIRECT = RESUME_ACCESS_TYPES.getById("direct");

    private ResumeAccessType() {
    }
}
