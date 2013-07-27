package ru.yaal.project.hhapi.search;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.vacancy.VacancyList;

import static org.junit.Assert.assertTrue;

public class ProfessionalFieldSearchTest {
    private ISearch<VacancyList> search = new VacancySearch();

    @Test
    public void test() throws DictionaryException, SearchException {
        ISearchParameter programming = Dictionaries.getInstance().getProfessionalFields().getById("1.221");
        ISearchParameter copywriter = Dictionaries.getInstance().getProfessionalFields().getById("3.119");
        search.addParameter(programming).addParameter(copywriter);
        VacancyList searchResult = search.search();
        assertTrue(15000 < searchResult.getFound());
    }
}
