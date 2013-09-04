package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import org.junit.Test;
import ru.yaal.project.hhapi.HhApi;
import ru.yaal.project.hhapi.dictionary.Constants;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.Address;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;

public class MetroLineTest {
    @Test
    public void searchByMetroLine() throws SearchException {
        MetroStation expMetro = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Площадь Восстания");
        MetroStation expMetro2 = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Маяковская");
        MetroStation expMetro3 = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Чернышевская");
        MetroStation expMetro4 = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Купчино");
        MetroStation expMetro5 = (MetroStation) MetroLine.SAINT_PETERSBURG.getByName("Обводный Канал");
        for (Vacancy vacancy : HhApi.search(30, expMetro)) {
            Address address = vacancy.getAddress();
            if (!address.isNull()) {
                MetroStation actStation = address.getStation();
                if (!actStation.isNull()) {
                    assertThat(actStation, isOneOf(expMetro, expMetro2, expMetro3, expMetro4, expMetro5));
                }
            }
        }
    }

    @Test
    public void searchByMultiMetroLines() throws Exception {
        MetroStation expMetro1 = (MetroStation) MetroLine.MOSCOW.getByName("Лубянка");
        MetroStation expMetro2 = (MetroStation) MetroLine.KAZAN.getByName("Горки");
        HhApi.search(50, Constants.Label.WITH_ADDRESS, expMetro1, expMetro2);
    }
}
