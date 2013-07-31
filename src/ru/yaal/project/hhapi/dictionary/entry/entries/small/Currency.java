package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Справочник валют.
 */
@ToString(callSuper = true)
public class Currency extends AbstractDictionaryEntry {
    public static final Currency NULL_CURRENCY = new Currency();
    public static final IDictionary<Currency> CURRENCIES = SmallDictionariesInitializer.getInstance().getCurrency();
    /**
     * Рубли.
     */
    public static final Currency RUR = CURRENCIES.getById("RUR");
    /**
     * Доллары.
     */
    public static final Currency USD = CURRENCIES.getById("USD");
    /**
     * Евро.
     */
    public static final Currency EUR = CURRENCIES.getById("EUR");
    /**
     * Манаты.
     */
    public static final Currency AZN = CURRENCIES.getById("AZN");
    /**
     * Белорусские рубли.
     */
    public static final Currency BYR = CURRENCIES.getById("BYR");
    /**
     * Тенге.
     */
    public static final Currency KZT = CURRENCIES.getById("KZT");
    /**
     * Гривны.
     */
    public static final Currency UAH = CURRENCIES.getById("UAH");
    @Getter
    @Setter
    @SerializedName("code")
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String id;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private Double rate;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String abbr;
    @SerializedName("default")
    private Boolean isDefault;

    private Currency() {
    }

    public Boolean isDefault() {
        return isDefault;
    }

    public void setDefault(Boolean def) {
        isDefault = def;
    }

}
