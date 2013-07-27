package ru.yaal.project.hhapi.dictionary;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.currency.Currency;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalField;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.EducationLevel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * ����� ������� ����������� � ��������� ��� �������� � API HH.
 *
 * @author Aleks
 */
public class DictionariesTest {
    @Test
    public void testCurrency() throws DictionaryException {
        IDictionary<Currency> dict = Dictionaries.getCurrency();
        assertEquals(7, dict.size());
        Currency rur = dict.getById("RUR");
        assertEquals("�����", rur.getName());
        assertEquals(true, rur.isDefault());
        assertEquals(new Double(1), rur.getRate());
        assertEquals("���.", rur.getAbbr());
    }

    @Test
    public void testEducationLevel() throws DictionaryException {
        IDictionary<EducationLevel> dict = Dictionaries.getEducationLevel();
        assertEquals(8, dict.size());
        EducationLevel higher = dict.getById("higher");
        assertNotNull(higher);
        assertEquals("������", higher.getName());
    }

    @Test
    public void testAreas() throws DictionaryException {
        IDictionary<Area> dict = Dictionaries2.getInstance().getAreas();
        assertEquals(6, dict.size());
    }

    @Test
    public void testProfessionalFields() throws DictionaryException {
        IDictionary<ProfessionalField> dict = Dictionaries2.getInstance().getProfessionalFields();
        assertEquals(28, dict.size());
    }

}
