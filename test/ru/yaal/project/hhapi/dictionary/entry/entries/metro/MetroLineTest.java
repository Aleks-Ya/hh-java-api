package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import org.junit.Test;
import ru.yaal.project.hhapi.TestHelper;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancyLabel;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.Address;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;

public class MetroLineTest {
    @Test
    public void searchByMetroLine() throws SearchException, DictionaryException {
        MetroStation metroExpected = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Площадь Восстания");
        MetroStation metroExpected2 = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Маяковская");
        MetroStation metroExpected3 = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Чернышевская");
        for (Vacancy vacancy : TestHelper.search(30, metroExpected)) {
            Address address = vacancy.getAddress();
            if (!address.isNull()) {
                MetroStation stationActual = address.getStation();
                if (!stationActual.isNull()) {
                    assertThat(stationActual, isOneOf(metroExpected, metroExpected2, metroExpected3));
                }
            }
        }
    }

    @Test
    public void searchByMultiMetroLines() throws Exception {
        MetroStation expMetro1 = (MetroStation) MetroLine.MOSCOW.getByName("Лубянка");
        MetroStation expMetro2 = (MetroStation) MetroLine.KAZAN.getByName("Горки");
        TestHelper.search(50, VacancyLabel.WITH_ADDRESS, expMetro1, expMetro2);
    }
}
