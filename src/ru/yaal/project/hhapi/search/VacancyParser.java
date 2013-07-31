package ru.yaal.project.hhapi.search;

import ru.yaal.project.hhapi.parser.AbstractParser;
import ru.yaal.project.hhapi.vacancy.Vacancy;

public class VacancyParser extends AbstractParser<Vacancy> {
    @Override
    public Vacancy parse(String content) {
        return getGson().fromJson(content, Vacancy.class);
    }
}
