package ru.yaal.project.hhapi.search;

import java.util.List;

import lombok.Data;
import ru.yaal.project.hhapi.Vacancy;

@Data
public class VacanciesList {
	private Integer found;
	private Integer pages;
	private Integer per_page;
	private Integer page;
	private List<Vacancy> items;
}
