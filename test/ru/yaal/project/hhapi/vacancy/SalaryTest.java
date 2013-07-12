package ru.yaal.project.hhapi.vacancy;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;

public class SalaryTest {
    @Test(expected = SearchException.class)
    public void testSalaryNotSpecified() throws SearchException, DictionaryException {
        ISearchParameter parameter = new Salary(null, null);
        parameter.getSearchParameters();
    }
}
