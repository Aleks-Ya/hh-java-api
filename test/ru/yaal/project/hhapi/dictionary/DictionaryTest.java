package ru.yaal.project.hhapi.dictionary;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.currency.Currency;
import ru.yaal.project.hhapi.loader.FakeContentLoader;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DictionaryTest {
    @Before
    public void before() {
        Dictionaries.setLoader(new FakeContentLoader());
    }

    @Test
    public void test() throws DictionaryException {
        Currency currency = new Currency();
        currency.setId("1");
        currency.setName("Рубли");
        Dictionary<Currency> currencyDictionary = new Dictionary<>(Currency.NULL_CURRENCY);
        currencyDictionary.putDictionaryEntry(currency);
        Currency currency2 = currencyDictionary.getEntryById(currency.getId());
        assertEquals(currency, currency2);
    }

    @Test
    public void iterable() {
        IDictionary<Currency> currencies = Dictionaries.getCurrency();
        List<Currency> actualCurrencies = new ArrayList<>(currencies.size());
        for (Currency currency : currencies) {
            actualCurrencies.add(currency);
        }
        List<Currency> expectedCurrencies = currencies.toList();
        assertEquals(expectedCurrencies.size(), actualCurrencies.size());
        assertTrue(actualCurrencies.containsAll(expectedCurrencies));
    }

}
