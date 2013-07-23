package ru.yaal.project.hhapi.vacancy;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import java.util.List;

@Data
public class VacancyList {
    private Integer found;
    private Integer pages;
    @SerializedName("per_page")
    private Integer perPage;
    private Integer page;
    private List<Vacancy> items;
}
