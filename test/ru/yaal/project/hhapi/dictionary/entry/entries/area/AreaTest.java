package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import org.junit.Test;
import ru.yaal.project.hhapi.TestHelper;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.IterableVacancyList;
import ru.yaal.project.hhapi.vacancy.IterableVacancySearch;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.*;

public class AreaTest {
    @Test
    public void testEquals() throws Exception {
        Area vologda1 = Area.AREAS.getByName("�������");
        Area vologda2 = Area.AREAS.getByName("�������");
        Area kiev = Area.AREAS.getByName("����");
        assertEquals(vologda1, vologda2);
        assertNotEquals(vologda1, kiev);
        assertFalse(vologda1.equals(null));
        assertFalse(vologda1.equals(new Object()));
        assertEquals(kiev, kiev);
    }

    @Test
    public void searchArea() throws SearchException, DictionaryException {
        final Area expArea = Area.AREAS.getByName("�����-���������");
        for (Vacancy vacancy : TestHelper.search(expArea)) {
            Area actualArea = vacancy.getArea();
            assertEquals(expArea, actualArea);
        }
    }

    @Test
    public void searchMultiParams() throws SearchException {
        Area expArea1 = Area.AREAS.getByName("�������");
        Area expArea2 = Area.AREAS.getByName("�������");
        for (Vacancy vacancy : TestHelper.search(expArea1, expArea2)) {
            Area actualArea = vacancy.getArea();
            assertThat(actualArea, isOneOf(expArea1, expArea2));
        }
    }

}
