package ru.yaal.project.hhapi.search;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.loader.FakeContentLoader;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.vacancy.VacanciesList;

import static org.junit.Assert.assertTrue;

public class ProfessionalFieldSearchTest {
    private ISearch<VacanciesList> search = new VacanciesSearch();
    @Test
    public void test() throws DictionaryException, SearchException {
        Dictionaries.setLoader(new FakeContentLoader());
        ISearchParameter programming = Dictionaries.getProfessionalField().getEntryById("1.221");
        ISearchParameter copywriter = Dictionaries.getProfessionalField().getEntryById("3.119");
        search.addParameter(programming).addParameter(copywriter);
        VacanciesList searchResult = search.search();
        assertTrue(15000 < searchResult.getFound());
    }
}
