package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import org.junit.Test;
import ru.yaal.project.hhapi.TestHelper;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancyLabel;

public class MetroLineTest {
    @Test
    public void multiParamSearch() throws Exception {
        MetroStation expectedMetro1 = (MetroStation) MetroLine.MOSCOW.getByName("�������");
        MetroStation expectedMetro2 = (MetroStation) MetroLine.KAZAN.getByName("�����");
        TestHelper.search(50, VacancyLabel.WITH_ADDRESS, expectedMetro1, expectedMetro2);
    }
}
