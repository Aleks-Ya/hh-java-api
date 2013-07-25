package ru.yaal.project.hhapi.parser;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCity;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCityDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroLine;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroStation;

import java.net.URL;

import static org.junit.Assert.assertEquals;

public class MetroParserTest {
    @Test
    public void testParse() throws Exception {
        MetroCityDictionary metroCityDictionary = Dictionaries.getMetro();
        final int metroCityCount = 12;
        assertEquals(metroCityCount, metroCityDictionary.size());
        MetroCity spb = metroCityDictionary.getById("2");
        assertEquals("Санкт-Петербург", spb.getName());
        assertEquals(new URL("https://api.hh.ru/metro/2"), spb.getUrl());
        IDictionary<MetroLine> lines = spb.getLines();
        assertEquals(5, lines.size());
        MetroLine line14 = lines.getById("14");
        assertEquals("Кировско-Выборгская", line14.getName());
        assertEquals("D6083B", line14.getHexColor());
        assertEquals(spb, line14.getCity());
        IDictionary<MetroStation> stations = line14.getStations();
        assertEquals(19, stations.size());
        MetroStation station = stations.getById("14.190");
        assertEquals("Девяткино", station.getName());
        assertEquals(new Integer(0), station.getOrder());
        assertEquals(new Double("60.050182"), station.getLat());
        assertEquals(new Double("30.443045000000001"), station.getLng());
        assertEquals(line14, station.getLine());
    }
}
