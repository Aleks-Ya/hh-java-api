package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import org.junit.Test;
import ru.yaal.project.hhapi.HhApi;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.*;

public class AreaTest {
    @Test
    public void testEquals() throws Exception {
        Area vologda1 = Area.AREAS.getByName("Вологда");
        Area vologda2 = Area.AREAS.getByName("Вологда");
        Area kiev = Area.AREAS.getByName("Киев");
        assertEquals(vologda1, vologda2);
        assertNotEquals(vologda1, kiev);
        assertFalse(vologda1.equals(null));
        assertFalse(vologda1.equals(new Object()));
        assertEquals(kiev, kiev);
    }

    @Test
    public void searchArea() throws SearchException {
        final Area expArea = Area.AREAS.getByName("Санкт-ПЕТЕРБУРГ");
        for (Vacancy vacancy : HhApi.search(expArea)) {
            Area actArea = vacancy.getArea();
            assertEquals(expArea, actArea);
        }
    }

    @Test
    public void searchMultiParams() throws SearchException {
        Area expArea1 = Area.AREAS.getByName("Саратов");
        Area expArea2 = Area.AREAS.getByName("Вологда");
        for (Vacancy vacancy : HhApi.search(expArea1, expArea2)) {
            Area actArea = vacancy.getArea();
            assertThat(actArea, isOneOf(expArea1, expArea2));
        }
    }

}
