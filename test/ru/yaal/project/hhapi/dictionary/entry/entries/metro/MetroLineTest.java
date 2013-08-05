package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import org.junit.Test;
import ru.yaal.project.hhapi.TestHelper;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancyLabel;

public class MetroLineTest {
    @Test
    public void multiParamSearch() throws Exception {
        MetroStation expMetro1 = (MetroStation) MetroLine.MOSCOW.getByName("Лубянка");
        MetroStation expMetro2 = (MetroStation) MetroLine.KAZAN.getByName("Горки");
        TestHelper.search(50, VacancyLabel.WITH_ADDRESS, expMetro1, expMetro2);
    }
}
