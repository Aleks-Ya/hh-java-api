package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import org.junit.Test;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.IterableVacancyList;
import ru.yaal.project.hhapi.vacancy.IterableVacancySearch;
import ru.yaal.project.hhapi.vacancy.Vacancy;

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
    public void searchMultiParams() throws SearchException {
        Area expectedArea1 = Area.AREAS.getByName("�������");
        Area expectedArea2 = Area.AREAS.getByName("�������");
        final int limit = 50;
        IterableVacancyList vacancies = new IterableVacancySearch(limit)
                .addParameter(expectedArea1)
                .addParameter(expectedArea2)
                .search();
        assertEquals(limit, vacancies.size());
        for (Vacancy vacancy : vacancies) {
            Area actualArea = vacancy.getArea();
            assertTrue(actualArea.equals(expectedArea1) || actualArea.equals(expectedArea2));
        }
    }
}
