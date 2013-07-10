package ru.yaal.project.hhapi.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.yaal.project.hhapi.dictionary.entry.entries.Currency;
import ru.yaal.project.hhapi.dictionary.entry.entries.EducationLevel;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;

/**
 * Тесты требуют подключения к Интернету для запросов к API HH.
 * @author Aleks
 *
 */
public class DictionariesHolderTest {

	@Test
	public void testCurrency() throws DictionaryException {
		Dictionary<Currency> dict = DictionariesHolder.getCurrencyDict();
		assertEquals(7, dict.size());
		Currency rur = dict.get("RUR");
		assertEquals("Рубли", rur.getName());
		assertEquals(true, rur.getIsDefault());
		assertEquals(new Double(1), rur.getRate());
		assertEquals("руб.", rur.getAbbr());
	}

	@Test
	public void testEducationLevel() throws DictionaryException {
		Dictionary<EducationLevel> dict = DictionariesHolder.getEducationLevelDict();
		assertEquals(8, dict.size());
		EducationLevel higher = dict.get("higher");
		assertNotNull(higher);
		assertEquals("Высшее", higher.getName());
	}
	
	@Test
	public void testAreas() throws DictionaryException {
		Dictionary<Area> dict = DictionariesHolder.getAreaDict();
		final int areasCount = 1695;//количество районов на 06.07.2013
		assertTrue(dict.size() >= areasCount);
		Area spb = dict.get("2");
		assertNotNull(spb);
		assertEquals("Санкт-Петербург", spb.getName());
	}

}
