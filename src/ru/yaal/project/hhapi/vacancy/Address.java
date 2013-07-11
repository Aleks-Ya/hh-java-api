package ru.yaal.project.hhapi.vacancy;

import lombok.Data;

@Data
public class Address {
    private String building;
    private String city;
    private String street;
    private String description;
    private String metro;
    private String raw;
    private Double lat;
    private Double lng;
}
