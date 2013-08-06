package ru.yaal.project.hhapi.vacancy;

import java.util.ArrayList;
import java.util.List;

public class VacancyList extends ArrayList<Vacancy> {

    public VacancyList(List<Vacancy> vacancies) {
        addAll(vacancies);
    }

}
