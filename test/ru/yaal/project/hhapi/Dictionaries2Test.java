package ru.yaal.project.hhapi;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries2;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.AreaDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCityDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalFieldDictionary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Dictionaries2Test {
    private static final String SPB = "Санкт-Петербург";
    private Dictionaries2 dictionaries2 = Dictionaries2.getInstance();

    @Test
    public void areas() throws Exception {
        AreaDictionary areas = dictionaries2.getAreas();
        assertEquals(SPB, areas.getByName(SPB).getName());
    }

    @Test
    public void metroCities() throws Exception {
        MetroCityDictionary metroCities = dictionaries2.getMetroCities();
        final String chern = "Чернышевская";
        assertEquals(chern, metroCities.getByName(SPB).getLines().getByName(chern).getName());
    }

    @Test
    public void professionalFields() throws Exception {
        ProfessionalFieldDictionary professionalFields = dictionaries2.getProfessionalFields();
        assertTrue(professionalFields.getById("1.221").getName().contains("Программирование"));
    }
}
