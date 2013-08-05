package ru.yaal.project.hhapi.vacancy;

import ru.yaal.project.hhapi.parser.AbstractParser;

public class VacanciesParser extends AbstractParser<VacancyPage> {
    @Override
    public VacancyPage parse(String content) {
        return getGson().fromJson(content, VacancyPage.class);
    }
}
