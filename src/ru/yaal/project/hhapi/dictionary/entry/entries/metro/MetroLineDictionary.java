package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.IDictionary;

import java.util.List;

public class MetroLineDictionary extends Dictionary<MetroLine> {
    public MetroLineDictionary() {
        super(MetroStation.NULL_METRO_STATION);
    }

    public MetroLineDictionary(List<MetroLine> metroLines) throws DictionaryException {
        super(MetroStation.NULL_METRO_STATION);
        for (MetroLine line : metroLines) {
            putDictionaryEntry(line);
        }
    }

    @Override
    public boolean hasEntryWithId(String id) {
        if (super.hasEntryWithId(id)) {
            return true;
        } else {
            for (MetroLine line : toList()) {
                IDictionary<MetroStation> stations = line.getStations();
                if (stations.hasEntryWithId(id)) return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasEntryWithName(String name) {
        if (super.hasEntryWithName(name)) {
            return true;
        } else {
            for (MetroLine line : toList()) {
                IDictionary<MetroStation> stations = line.getStations();
                if (stations.hasEntryWithName(name)) return true;
            }
        }
        return false;
    }

    @Override
    public MetroLine getEntryById(String id) {
        if (hasEntryWithId(id)) {
            if (super.hasEntryWithId(id)) {
                return super.getEntryById(id);
            } else {
                for (MetroLine line : toList()) {
                    IDictionary<MetroStation> stations = line.getStations();
                    if (stations.hasEntryWithId(id)) return stations.getEntryById(id);
                }
            }
        }
        return nullObject;
    }

    @Override
    public MetroLine getEntryByName(String name) {
        if (hasEntryWithName(name)) {
            if (super.hasEntryWithName(name)) {
                return super.getEntryByName(name);
            } else {
                for (MetroLine line : toList()) {
                    IDictionary<MetroStation> stations = line.getStations();
                    if (stations.hasEntryWithName(name)) return stations.getEntryByName(name);
                }
            }
        }
        return nullObject;
    }
}
