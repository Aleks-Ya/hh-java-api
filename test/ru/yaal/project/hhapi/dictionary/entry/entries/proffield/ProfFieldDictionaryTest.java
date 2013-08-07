package ru.yaal.project.hhapi.dictionary.entry.entries.proffield;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.junit.Assert.*;

public class ProfFieldDictionaryTest {
    private static final String FIELD_ID = "1";
    private static final String FIELD_NAME = "»Ì‘Ó–Ï¿ˆ»ÓÕÌ€Â “Â’ÌŒÎŒ„»Ë, »Ì“Â–Ì≈Ú, “ÂÀÂ ÓÃ";
    private static final String SPECIALIZATION_ID = "1.221";
    private static final String SPECIALIZATION_NAME = "œŒ„–‡ÃÏ»Œ‚¿Ì»Â, –‡«¿·ŒÚ ‡";
    private ProfFieldDictionary dictionary;

    @Before
    public void before() {
        dictionary = ProfField.PROF_FIELDS;
    }

    @Test
    public void hasWithId() {
        assertTrue(dictionary.hasId(FIELD_ID));
        assertTrue(dictionary.hasId(SPECIALIZATION_ID));
        assertFalse(dictionary.hasId("1000"));
    }

    @Test
    public void hasWithName() {
        assertTrue(dictionary.hasName(FIELD_NAME));
        assertTrue(dictionary.hasName(SPECIALIZATION_NAME));
        assertFalse(dictionary.hasName("1000"));
    }

    @Test
    public void getById() {
        assertTrue(FIELD_NAME.equalsIgnoreCase(dictionary.getById(FIELD_ID).getName()));
        assertThat(SPECIALIZATION_NAME, equalToIgnoringCase(dictionary.getById(SPECIALIZATION_ID).getName()));
    }

    @Test
    public void getByName() {
        assertEquals(FIELD_ID, dictionary.getByName(FIELD_NAME).getId());
        assertEquals(SPECIALIZATION_ID, dictionary.getByName(SPECIALIZATION_NAME).getId());
    }
}
