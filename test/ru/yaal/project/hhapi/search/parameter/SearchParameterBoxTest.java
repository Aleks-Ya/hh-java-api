package ru.yaal.project.hhapi.search.parameter;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Employment;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Experience;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.VacancyList;
import ru.yaal.project.hhapi.search.VacanciesSearch;

public class SearchParameterBoxTest {
    private final SearchParameterBox box = new SearchParameterBox();

    @Test
    public void multipleParamsAccepted() throws SearchException {
        box.addParameter(SearchParamNames.EMPLOYMENT, Employment.PART.getId());
        box.addParameter(SearchParamNames.EMPLOYMENT, Employment.FULL.getId());
    }

    @Test(expected = SearchException.class)
    public void multipleParamsNotAcceptedBox() throws SearchException {
        box.addParameter(SearchParamNames.EXPERIENCE, Experience.BETWEEN_1_AND_3.getId());
        box.addParameter(SearchParamNames.EXPERIENCE, Experience.BETWEEN_3_AND_6.getId());
    }

    @Test(expected = SearchException.class)
    public void multipleParamsNotAcceptedSearch() throws SearchException {
        ISearch<VacancyList> search = new VacanciesSearch();
        search.addParameter(new Text("one"));
        search.addParameter(new Text("two"));
    }
}
