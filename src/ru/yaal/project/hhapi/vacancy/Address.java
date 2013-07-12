package ru.yaal.project.hhapi.vacancy;

import lombok.Data;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCity;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCity;

@Data
public class Address {
    private String building;
    private String city;
    private String street;
    private String description;
    private MetroCity metro;
    private String raw;
    private Double lat;
    private Double lng;
}
