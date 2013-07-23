package ru.yaal.project.hhapi.dictionary.entry;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Gender;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Schedule;

import static org.junit.Assert.assertEquals;

public class AbstractDictionaryEntryTest {
    @Test
    public void testToString() throws Exception {
        assertEquals("Мужской(male)", Gender.MALE.toString());
        assertEquals("Полный день(fullDay)", Schedule.FULL_DAY.toString());
        assertEquals("Санкт-Петербург(2)", Dictionaries.getArea().getEntryByName("Санкт-Петербург").toString());
        assertEquals("Программирование, Разработка(1.221)",
                Dictionaries.getProfessionalField().getEntryById("1.221").toString());
        assertEquals("Кольцевая(5)", Dictionaries.getMetro().getEntryByName("Кольцевая").toString());
        assertEquals("Чернышевская(14.198)", Dictionaries.getMetro().getEntryByName("Чернышевская").toString());
    }
}
