package ru.yaal.project.hhapi.vacancy;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = "items")
public class VacancyList {
    @SuppressWarnings("PMD.UnusedPrivateField")
    private Integer found;
    @SuppressWarnings("PMD.UnusedPrivateField")
    private Integer pages;
    @SerializedName("per_page")
    @SuppressWarnings("PMD.UnusedPrivateField")
    private Integer perPage;
    @SuppressWarnings("PMD.UnusedPrivateField")
    private Integer page;
    @SuppressWarnings("PMD.UnusedPrivateField")
    private List<Vacancy> items;
}
