package ru.yaal.project.hhapi.search;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import java.util.List;

@Data
public class VacanciesList {
    private Integer found;
    private Integer pages;
    @SerializedName("per_page")
    private Integer perPage;
    private Integer page;
    private List<Vacancy> items;
}
