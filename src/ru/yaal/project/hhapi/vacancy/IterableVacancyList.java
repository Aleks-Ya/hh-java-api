package ru.yaal.project.hhapi.vacancy;

import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.search.SearchException;

import java.util.List;

public class IterableVacancyList extends Dictionary<Vacancy> {

    public IterableVacancyList(VacancyList vacancyFullList) throws DictionaryException {
        super(vacancyFullList.getItems(), Vacancy.NULL_VACANCY);
    }

    public IterableVacancyList(List<Vacancy> vacancyFullCollection) throws DictionaryException {
        super(vacancyFullCollection, Vacancy.NULL_VACANCY);
    }

    public IterableVacancyList(PageableVacancyList pageableVacancyList) throws DictionaryException, SearchException {
        super(pageableVacancyList.toList().toList(), Vacancy.NULL_VACANCY);

    }

    @Override
    protected void putName(Vacancy entry) throws DictionaryException {
        //ѕоиск вакансии по имени не поддерживаетс€, т.к. имена (названи€) вакансий не уникальны.
    }

    @Override
    public Vacancy getEntryByName(String name) {
        throw new UnsupportedOperationException("ѕоиск вакансии по имени не поддерживаетс€, т.к. имена (названи€) вакансий не уникальны.");
    }
}
