package ru.yaal.project.hhapi.parser;

import ru.yaal.project.hhapi.vacancy.VacanciesList;

public class VacanciesParser extends AbstractParser<VacanciesList> {
    @Override
    public VacanciesList parse(String content) {
        return gson.fromJson(content, VacanciesList.class);
    }
}
