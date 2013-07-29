package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import org.junit.Test;
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
}
