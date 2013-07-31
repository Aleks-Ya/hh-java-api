package ru.yaal.project.hhapi.dictionary.entry.entries.employer;

import ru.yaal.project.hhapi.parser.AbstractParser;

final class EmployerParser extends AbstractParser<EmployerSingle> {
    @Override
    public EmployerSingle parse(String content) {
        return getGson().fromJson(content, EmployerSingle.class);
    }
}
