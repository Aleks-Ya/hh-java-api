package ru.yaal.project.hhapi.vacancy;

import ru.yaal.project.hhapi.parser.AbstractParser;

public class VacancyParser extends AbstractParser<Vacancy> {
    @Override
    public Vacancy parse(String content) {
        return getGson().fromJson(content, Vacancy.class);
    }
}
