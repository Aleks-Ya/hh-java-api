package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Валюта.
 * @see ru.yaal.project.hhapi.dictionary.Constants.Currency
 */
@ToString(of = {"id", "abbr"})
public final class Currency extends AbstractDictionaryEntry {
    public static final Currency NULL_CURRENCY = new Currency();
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
