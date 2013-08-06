package ru.yaal.project.hhapi.dictionary;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.AreaDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCity;
import ru.yaal.project.hhapi.dictionary.entry.entries.proffield.ProfField;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Dictionaries2Test {
    private static final String SPB = "Санкт-Петербург";

    @Test
    public void areas() throws Exception {
        AreaDictionary areas = Area.AREAS;
        assertEquals(SPB, areas.getByName(SPB).getName());
    }

    @Test
    public void metroCities() throws Exception {
        final String chern = "Чернышевская";
        assertEquals(chern, MetroCity.CITIES.getByName(SPB).getLines().getByName(chern).getName());
    }

    @Test
    public void profFields() throws Exception {
        assertThat(ProfField.PROF_FIELDS.getById("1.221").getName(), containsString("Программирование"));
    }
}
