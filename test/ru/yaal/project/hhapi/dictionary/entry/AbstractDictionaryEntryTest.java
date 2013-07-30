package ru.yaal.project.hhapi.dictionary.entry;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroLine;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalField;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.Gender;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.Schedule;

import static org.junit.Assert.assertEquals;

public class AbstractDictionaryEntryTest {
    @Test
    public void testToString() throws Exception {
        assertEquals("Мужской(male)", Gender.MALE.toString());
        assertEquals("Полный день(fullDay)", Schedule.FULL_DAY.toString());
        assertEquals("Санкт-Петербург(2)", Area.AREAS.getByName("Санкт-Петербург").toString());
        assertEquals("Программирование, Разработка(1.221)",
                ProfessionalField.PROFESSIONAL_FIELDS.getById("1.221").toString());
        assertEquals("Кольцевая(5)", MetroLine.MOSCOW.getByName("Кольцевая").toString());
        assertEquals("Чернышевская(14.198)", MetroLine.SAINT_PETERSBURG.getByName("Чернышевская").toString());
    }
}
