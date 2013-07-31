package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancyLabel;
import ru.yaal.project.hhapi.vacancy.IterableVacancyList;
import ru.yaal.project.hhapi.vacancy.IterableVacancySearch;

import static org.junit.Assert.assertEquals;

public class MetroLineTest {
    @Test
    public void multiParamSearch() throws Exception {
        MetroStation expectedMetro1 = (MetroStation) MetroLine.MOSCOW.getByName("Лубянка");
        MetroStation expectedMetro2 = (MetroStation) MetroLine.KAZAN.getByName("Горки");
        final int limit = 50;
        IterableVacancyList vacancies = new IterableVacancySearch(limit)
                .addParameter(VacancyLabel.WITH_ADDRESS)
                .addParameter(expectedMetro1)
                .addParameter(expectedMetro2)
                .search();
        assertEquals(limit, vacancies.size());
    }
}
