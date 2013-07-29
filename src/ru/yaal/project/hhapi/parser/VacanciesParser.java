package ru.yaal.project.hhapi.parser;

import ru.yaal.project.hhapi.vacancy.VacancyList;

public class VacanciesParser extends AbstractParser<VacancyList> {
    @Override
    public VacancyList parse(String content) {
        return getGson().fromJson(content, VacancyList.class);
    }
}
