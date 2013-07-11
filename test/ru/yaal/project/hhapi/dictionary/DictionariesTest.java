package ru.yaal.project.hhapi.dictionary;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.Currency;
import ru.yaal.project.hhapi.dictionary.entry.entries.EducationLevel;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalField;
import ru.yaal.project.hhapi.loader.FakeContentLoader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Тесты требуют подключения к Интернету для запросов к API HH.
 *
 * @author Aleks
 */
public class DictionariesTest {
    private static Dictionaries dictionaries;

    @BeforeClass
    public static void beforeClass() throws DictionaryException {
        dictionaries = Dictionaries.getInstance(new FakeContentLoader());
    }

    @Test
    public void testCurrency() throws DictionaryException {
        IDictionary<Currency> dict = dictionaries.currencyCache;
        assertEquals(7, dict.size());
        Currency rur = dict.getEntryById("RUR");
        assertEquals("Рубли", rur.getName());
        assertEquals(true, rur.isDefault());
        assertEquals(new Double(1), rur.getRate());
        assertEquals("руб.", rur.getAbbr());
    }

    @Test
    public void testEducationLevel() throws DictionaryException {
        Dictionary<EducationLevel> dict = dictionaries.educationLevelCache;
        assertEquals(8, dict.size());
        EducationLevel higher = dict.get("higher");
        assertNotNull(higher);
        assertEquals("Высшее", higher.getName());
    }

    @Test
    public void testAreas() throws DictionaryException {
        Dictionary<Area> dict = dictionaries.areaCache;
        assertEquals(6, dict.size());
    }

    @Test
    public void testProfessionalFields() throws DictionaryException {
        Dictionary<ProfessionalField> dict = dictionaries.professionalFieldCache;
        assertEquals(28, dict.size());
    }

}
