package ru.yaal.project.hhapi.dictionary;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import ru.yaal.project.hhapi.dictionary.entry.entries.Currency;
import ru.yaal.project.hhapi.dictionary.entry.entries.EducationLevel;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.loader.FakeContentLoader;

/**
 * Тесты требуют подключения к Интернету для запросов к API HH.
 * @author Aleks
 *
 */
public class DictionariesHolderTest {
    private static DictionariesHolder dictionariesHolder;

    @BeforeClass
    public static void beforeClass() throws DictionaryException {
        dictionariesHolder = DictionariesHolder.getInstance(new FakeContentLoader());
    }

	@Test
	public void testCurrency() throws DictionaryException {
		IDictionary<Currency> dict = dictionariesHolder.currencyCache;
		assertEquals(7, dict.size());
		Currency rur = dict.getEntryById("RUR");
		assertEquals("Рубли", rur.getName());
		assertEquals(true, rur.isDefault());
		assertEquals(new Double(1), rur.getRate());
		assertEquals("руб.", rur.getAbbr());
	}

	@Test
	public void testEducationLevel() throws DictionaryException {
		Dictionary<EducationLevel> dict = dictionariesHolder.educationLevelCache;
		assertEquals(8, dict.size());
		EducationLevel higher = dict.get("higher");
		assertNotNull(higher);
		assertEquals("Высшее", higher.getName());
	}
	
	@Test
	public void testAreas() throws DictionaryException {
		Dictionary<Area> dict = dictionariesHolder.areaCache;
        assertEquals(6, dict.size());
	}

}
