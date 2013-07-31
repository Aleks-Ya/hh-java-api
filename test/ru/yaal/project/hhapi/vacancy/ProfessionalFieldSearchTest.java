package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalField;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;

import static org.junit.Assert.assertTrue;

public class ProfessionalFieldSearchTest {
    private ISearch<VacancyList> search = new VacancySearch();

    @Test
    public void test() throws DictionaryException, SearchException {
        ISearchParameter programming = ProfessionalField.PROFESSIONAL_FIELDS.getById("1.221");
        ISearchParameter copywriter = ProfessionalField.PROFESSIONAL_FIELDS.getById("3.119");
        search.addParameter(programming).addParameter(copywriter);
        VacancyList searchResult = search.search();
        assertTrue(15000 < searchResult.getFound());
    }
}
