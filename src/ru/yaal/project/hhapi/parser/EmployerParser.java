package ru.yaal.project.hhapi.parser;

import ru.yaal.project.hhapi.dictionary.entry.entries.employer.EmployerSingle;

public class EmployerParser extends AbstractParser<EmployerSingle> {
    @Override
    public EmployerSingle parse(String content) {
        return gson.fromJson(content, EmployerSingle.class);
    }
}
