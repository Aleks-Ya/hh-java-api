package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import org.junit.Test;
import ru.yaal.project.hhapi.TestHelper;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.Label;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.Address;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;

public class MetroLineTest {
    @Test
    public void searchByMetroLine() throws SearchException, DictionaryException {
        MetroStation expMetro = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Площадь Восстания");
        MetroStation expMetro2 = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Маяковская");
        MetroStation expMetro3 = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Чернышевская");
        MetroStation expMetro4 = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Купчино");
        for (Vacancy vacancy : TestHelper.search(30, expMetro)) {
            Address address = vacancy.getAddress();
            if (!address.isNull()) {
                MetroStation actStation = address.getStation();
                if (!actStation.isNull()) {
                    assertThat(actStation, isOneOf(expMetro, expMetro2, expMetro3, expMetro4));
                }
            }
        }
    }

    @Test
    public void searchByMultiMetroLines() throws Exception {
        MetroStation expMetro1 = (MetroStation) MetroLine.MOSCOW.getByName("Лубянка");
        MetroStation expMetro2 = (MetroStation) MetroLine.KAZAN.getByName("Горки");
        TestHelper.search(50, Label.WITH_ADDRESS, expMetro1, expMetro2);
    }
}
