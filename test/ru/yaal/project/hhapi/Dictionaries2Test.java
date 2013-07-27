package ru.yaal.project.hhapi;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.AreaDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCityDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalFieldDictionary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Dictionaries2Test {
    private static final String SPB = "Санкт-Петербург";
    private Dictionaries dictionaries = Dictionaries.getInstance();

    @Test
    public void areas() throws Exception {
        AreaDictionary areas = dictionaries.getAreas();
        assertEquals(SPB, areas.getByName(SPB).getName());
    }

    @Test
    public void metroCities() throws Exception {
        MetroCityDictionary metroCities = dictionaries.getMetroCities();
        final String chern = "Чернышевская";
        assertEquals(chern, metroCities.getByName(SPB).getLines().getByName(chern).getName());
    }

    @Test
    public void professionalFields() throws Exception {
        ProfessionalFieldDictionary professionalFields = dictionaries.getProfessionalFields();
        assertTrue(professionalFields.getById("1.221").getName().contains("Программирование"));
    }
}
