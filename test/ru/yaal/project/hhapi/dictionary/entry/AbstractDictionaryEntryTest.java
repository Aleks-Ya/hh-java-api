package ru.yaal.project.hhapi.dictionary.entry;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries2;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Gender;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Schedule;

import static org.junit.Assert.assertEquals;

public class AbstractDictionaryEntryTest {
    @Test
    public void testToString() throws Exception {
        assertEquals("�������(male)", Gender.MALE.toString());
        assertEquals("������ ����(fullDay)", Schedule.FULL_DAY.toString());
        assertEquals("�����-���������(2)", Dictionaries2.getInstance().getAreas().getByName("�����-���������").toString());
        assertEquals("����������������, ����������(1.221)",
                Dictionaries2.getInstance().getProfessionalFields().getById("1.221").toString());
        assertEquals("���������(5)", Dictionaries2.getInstance().getMetroCities().getByName("���������").toString());
        assertEquals("������������(14.198)", Dictionaries2.getInstance().getMetroCities().getByName("������������").toString());
    }
}
