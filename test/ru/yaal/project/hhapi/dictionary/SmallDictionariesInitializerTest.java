package ru.yaal.project.hhapi.dictionary;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency;
import ru.yaal.project.hhapi.dictionary.entry.entries.proffield.ProfField;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.SmallDictionariesInitializer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Тесты требуют подключения к Интернету для запросов к API HH.
 *
 * @author Aleks
 */
public class SmallDictionariesInitializerTest {
    @Test
    public void testCurrency() {
        IDictionary<Currency> dict = SmallDictionariesInitializer.getInstance().getCurrency();
        assertEquals(7, dict.size());
        Currency rur = dict.getById("RUR");
        assertEquals("Рубли", rur.getName());
        assertEquals(true, rur.isDefault());
        assertEquals(new Double(1), rur.getRate());
        assertEquals("руб.", rur.getAbbr());
    }

    @Test
    public void testEducationLevel() {
        IDictionary<EducationLevel> dict = SmallDictionariesInitializer.getInstance().getEducationLevel();
        assertEquals(8, dict.size());
        EducationLevel higher = dict.getById("higher");
        assertNotNull(higher);
        assertEquals("Высшее", higher.getName());
    }

    @Test
    public void testAreas() {
        assertEquals(6, Area.AREAS.size());
    }

    @Test
    public void testProfFields() {
        assertEquals(28, ProfField.PROF_FIELDS.size());
    }

}
