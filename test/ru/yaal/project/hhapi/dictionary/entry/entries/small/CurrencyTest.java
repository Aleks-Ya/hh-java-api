package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.junit.Test;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.assertThat;

public class CurrencyTest {
    @Test
    public void testToString() throws Exception {
        Currency c = Currency.RUR;
        assertThat(c.toString(), equalToIgnoringCase("Currency(id=RUR, abbr=руб.)"));
    }
}
