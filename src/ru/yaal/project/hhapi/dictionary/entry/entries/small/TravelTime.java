package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Время в пути (резюме).
 * @see ru.yaal.project.hhapi.dictionary.Constants.TravelTime
 */
public final class TravelTime extends AbstractDictionaryEntry {
    public static final TravelTime NULL_TRAVEL_TIME = new TravelTime();

    private TravelTime() {
    }
}
