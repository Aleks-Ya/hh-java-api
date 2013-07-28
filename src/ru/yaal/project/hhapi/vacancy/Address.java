package ru.yaal.project.hhapi.vacancy;

import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.dictionary.INullable;

public class Address implements INullable {
    public static final Address NULL_ADDRESS = new Address();
    private static final String NULL_CITY = "NullCity";
    @Getter
    @Setter
    private String building;
    @Getter
    @Setter
    private String city;
    @Getter
    @Setter
    private String street;
    @Getter
    @Setter
    private String description;
    @Setter
    private Metro metro;
    @Getter
    @Setter
    private String raw;
    @Getter
    @Setter
    private Double lat;
    @Getter
    @Setter
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
