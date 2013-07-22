package ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield;

import org.junit.Before;
import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.DictionaryException;

import static org.junit.Assert.*;

public class ProfessionalFieldDictionaryTest {
    private static final String FIELD_ID = "1";
    private static final String FIELD_NAME = "»Ì‘Ó–Ï¿ˆ»ÓÕÌ€Â “Â’ÌŒÎŒ„»Ë, »Ì“Â–Ì≈Ú, “ÂÀÂ ÓÃ";
    private static final String SPECIALIZATION_ID = "1.221";
    private static final String SPECIALIZATION_NAME = "œŒ„–‡ÃÏ»Œ‚¿Ì»Â, –‡«¿·ŒÚ ‡";
    private ProfessionalFieldDictionary dictionary;

    @Before
    public void before() throws DictionaryException {
        dictionary = Dictionaries.getProfessionalField();
    }

    @Test
    public void hasWithId() throws DictionaryException {
        assertTrue(dictionary.hasEntryWithId(FIELD_ID));
        assertTrue(dictionary.hasEntryWithId(SPECIALIZATION_ID));
        assertFalse(dictionary.hasEntryWithId("1000"));
    }

    @Test
    public void hasWithName() throws DictionaryException {
        assertTrue(dictionary.hasEntryWithName(FIELD_NAME));
        assertTrue(dictionary.hasEntryWithName(SPECIALIZATION_NAME));
        assertFalse(dictionary.hasEntryWithName("1000"));
    }

    @Test
    public void getById() throws DictionaryException {
        assertTrue(FIELD_NAME.equalsIgnoreCase(dictionary.getEntryById(FIELD_ID).getName()));
        assertTrue(SPECIALIZATION_NAME.equalsIgnoreCase(dictionary.getEntryById(SPECIALIZATION_ID).getName()));
    }

    @Test
    public void getByName() throws DictionaryException {
        assertEquals(FIELD_ID, dictionary.getEntryByName(FIELD_NAME).getId());
        assertEquals(SPECIALIZATION_ID, dictionary.getEntryByName(SPECIALIZATION_NAME).getId());
    }
}
