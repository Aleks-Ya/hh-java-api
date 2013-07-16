package ru.yaal.project.hhapi.dictionary;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.currency.Currency;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.EducationLevel;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalField;
import ru.yaal.project.hhapi.loader.FakeContentLoader;

import static org.junit.Assert.*;

/**
 * Тесты требуют подключения к Интернету для запросов к API HH.
 *
 * @author Aleks
 */
public class DictionariesTest {
    @BeforeClass
    public static void beforeClass() throws DictionaryException {
        Dictionaries.setLoader(new FakeContentLoader());
    }

    @Test
    public void testCurrency() throws DictionaryException {
        IDictionary<Currency> dict = Dictionaries.getCurrency();
        assertEquals(7, dict.size());
        Currency rur = dict.getEntryById("RUR");
        assertEquals("Рубли", rur.getName());
        assertEquals(true, rur.isDefault());
        assertEquals(new Double(1), rur.getRate());
        assertEquals("руб.", rur.getAbbr());
    }

    @Test
    public void testEducationLevel() throws DictionaryException {
        IDictionary<EducationLevel> dict = Dictionaries.getEducationLevel();
        assertEquals(8, dict.size());
        EducationLevel higher = dict.getEntryById("higher");
        assertNotNull(higher);
        assertEquals("Высшее", higher.getName());
    }

    @Test
    public void testAreas() throws DictionaryException {
        IDictionary<Area> dict = Dictionaries.getArea();
        assertTrue(1500 < dict.size());
    }

    @Test
    public void testProfessionalFields() throws DictionaryException {
        IDictionary<ProfessionalField> dict = Dictionaries.getProfessionalField();
        assertEquals(28, dict.size());
    }

}
