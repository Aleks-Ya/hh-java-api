package ru.yaal.project.hhapi.dictionary.entry.entries.currency;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

@ToString(callSuper = true)
public class Currency extends AbstractDictionaryEntry {
    public static final Currency NULL_CURRENCY = new Currency();
    public static final Currency RUR = Dictionaries.getInstance().getCurrency().getById("RUR");
    public static final Currency USD = Dictionaries.getInstance().getCurrency().getById("USD");
    public static final Currency EUR = Dictionaries.getInstance().getCurrency().getById("EUR");
    @Getter
    @Setter
    @SerializedName("code")
    private String id;
    @Getter
    @Setter
    private Double rate;
    @Getter
    @Setter
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
