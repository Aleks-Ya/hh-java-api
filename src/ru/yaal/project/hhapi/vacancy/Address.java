package ru.yaal.project.hhapi.vacancy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.yaal.project.hhapi.dictionary.entry.INullable;

@ToString
public final class Address implements INullable {
    public static final Address NULL_ADDRESS = new Address();
    private static final String NULL_CITY = "NullCity";
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String building;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String city;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String street;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String description;
    @Setter
    private Metro metro;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String raw;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private Double lat;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private Double lng;

    public Address() {
        setCity(NULL_CITY);
    }

    @Override
    public boolean isNull() {
        return (getCity() == null || getCity().isEmpty() || NULL_CITY.equalsIgnoreCase(getCity()));
    }

    public Metro getMetro() {
        return (metro != null) ? metro : Metro.NULL_METRO;
    }
}
