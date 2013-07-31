package ru.yaal.project.hhapi.vacancy;

import ru.yaal.project.hhapi.parser.AbstractParser;

public class VacanciesParser extends AbstractParser<VacancyList> {
    @Override
    public VacancyList parse(String content) {
        return getGson().fromJson(content, VacancyList.class);
    }
}
