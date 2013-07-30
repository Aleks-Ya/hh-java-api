package ru.yaal.project.hhapi.dictionary.entry.entries.currency;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

@ToString(callSuper = true)
public class Currency extends AbstractDictionaryEntry {
    public static final Currency NULL_CURRENCY = new Currency();
    public static final IDictionary<Currency> CURRENCIES = Dictionaries.getInstance().getCurrency();
    public static final Currency RUR = CURRENCIES.getById("RUR");
    public static final Currency USD = CURRENCIES.getById("USD");
    public static final Currency EUR = CURRENCIES.getById("EUR");
    public static final Currency AZN = CURRENCIES.getById("AZN");
    public static final Currency BYR = CURRENCIES.getById("BYR");
    public static final Currency KZT = CURRENCIES.getById("KZT");
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

    Currency() {
    }

    public Boolean isDefault() {
        return isDefault;
    }

    public void setDefault(Boolean def) {
        isDefault = def;
    }

}
