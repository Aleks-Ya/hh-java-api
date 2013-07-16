package ru.yaal.project.hhapi.vacancy;

import lombok.Data;
import ru.yaal.project.hhapi.dictionary.Nullable;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCity;

@Data
public class Address implements Nullable {
    public static final Address NULL_ADDRESS = new Address();
    private static final String NULL_CITY = "NullCity";
    private String building;
    private String city;
    private String street;
    private String description;
    private MetroCity metro;
    private String raw;
    private Double lat;
    private Double lng;

    public Address() {
        setCity(NULL_CITY);
    }

    @Override
    public boolean isNull() {
        return (getCity() == null || getCity().isEmpty() || NULL_CITY.equalsIgnoreCase(getCity()));
    }
}
