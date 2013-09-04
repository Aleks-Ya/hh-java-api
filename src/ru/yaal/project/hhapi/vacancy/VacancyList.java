package ru.yaal.project.hhapi.vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Список вакансий - результат поиска вакансий.
 * Реализует {@code List<Vacancy>}.
 */
public class VacancyList extends ArrayList<Vacancy> {

    public VacancyList(List<Vacancy> vacancies) {
        addAll(vacancies);
    }

}
