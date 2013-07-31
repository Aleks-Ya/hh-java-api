package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * ���������� � �������� (������).
 */
public final class RelocationType extends AbstractDictionaryEntry {
    public static final RelocationType NULL_RELOCATION_TYPE = new RelocationType();
    public static final IDictionary<RelocationType> RELOCATION_TYPES = SmallDictionariesInitializer.getInstance().getRelocationType();
    /**
     * �� ����� � ��������.
     */
    public static final RelocationType NO_RELOCATION = RELOCATION_TYPES.getById("no_relocation");
    /**
     * ����� � ��������.
     */
    public static final RelocationType POSSIBLE = RELOCATION_TYPES.getById("relocation_possible");
    /**
     * ���� ���������.
     */
    public static final RelocationType DESIRABLE = RELOCATION_TYPES.getById("relocation_desirable");

    private RelocationType() {
    }
}
