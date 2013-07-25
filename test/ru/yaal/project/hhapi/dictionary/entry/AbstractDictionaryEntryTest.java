package ru.yaal.project.hhapi.dictionary.entry;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Gender;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Schedule;

import static org.junit.Assert.assertEquals;

public class AbstractDictionaryEntryTest {
    @Test
    public void testToString() throws Exception {
        assertEquals("�������(male)", Gender.MALE.toString());
        assertEquals("������ ����(fullDay)", Schedule.FULL_DAY.toString());
        assertEquals("�����-���������(2)", Dictionaries.getArea().getByName("�����-���������").toString());
        assertEquals("����������������, ����������(1.221)",
                Dictionaries.getProfessionalField().getById("1.221").toString());
        assertEquals("���������(5)", Dictionaries.getMetro().getByName("���������").toString());
        assertEquals("������������(14.198)", Dictionaries.getMetro().getByName("������������").toString());
    }
}
