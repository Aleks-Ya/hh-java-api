package ru.yaal.project.hhapi.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.yaal.project.hhapi.dictionary.entry.entries.Currency;

public class DictionaryTest {

	@Test
	public void test() {
		Currency currency = new Currency();
		currency.setId("1");
		Dictionary<Currency> currncyDictionary = new Dictionary<>();
		currncyDictionary.putDictionaryEntry(currency);
		Currency currency2 = currncyDictionary.get(currency.getId());
		assertEquals(currency, currency2);
	}

}
