package ru.yaal.project.hhapi.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.yaal.project.hhapi.dictionary.entry.entries.Currency;

public class DictionaryTest {

	@Test
	public void test() throws DictionaryException {
		Currency currency = new Currency();
		currency.setId("1");
		Dictionary<Currency> currencyDictionary = new Dictionary<>();
		currencyDictionary.putDictionaryEntry(currency);
		Currency currency2 = currencyDictionary.getEntryById(currency.getId());
		assertEquals(currency, currency2);
	}

}
