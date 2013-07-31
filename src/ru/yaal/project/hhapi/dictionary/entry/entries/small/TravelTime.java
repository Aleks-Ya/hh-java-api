package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * ����� � ���� (������).
 */
public final class TravelTime extends AbstractDictionaryEntry {
    public static final TravelTime NULL_TRAVEL_TIME = new TravelTime();
    public static final IDictionary<TravelTime> TRAVEL_TIMES = SmallDictionariesInitializer.getInstance().getTravelTime();
    /**
     * �� ����� ��������.
     */
    public static final TravelTime ANY = TRAVEL_TIMES.getById("any");
    /**
     * �� ����� ����.
     */
    public static final TravelTime LESS_THAN_HOUR = TRAVEL_TIMES.getById("less_than_hour");
    /**
     * �� ����� �������� �����.
     */
    public static final TravelTime FROM_HOUR_TO_ONE_AND_HALF = TRAVEL_TIMES.getById("from_hour_to_one_and_half");

    private TravelTime() {
    }
}
