package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Готовность к командировкам (резюме).
 */
public class BusinessTripReadiness extends AbstractDictionaryEntry {
    public static final BusinessTripReadiness NULL_BUSINESS_TRIP_READINESS = new BusinessTripReadiness();
    public static final IDictionary<BusinessTripReadiness> READINESS = SmallDictionariesInitializer.getInstance().getBusinessTripReadiness();
    /**
     * Готов к командировкам.
     */
    public static final BusinessTripReadiness READY = READINESS.getById("ready");
    /**
     * Готов к редким командировкам.
     */
    public static final BusinessTripReadiness SOMETIMES = READINESS.getById("sometimes");
    /**
     * Не готов к командировкам.
     */
    public static final BusinessTripReadiness NEVER = READINESS.getById("never");

    private BusinessTripReadiness() {
    }
}
