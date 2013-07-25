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
            addEntry(line);
        }
    }

    @Override
    public boolean hasId(String id) {
        if (super.hasId(id)) {
            return true;
        } else {
            for (MetroLine line : toList()) {
                IDictionary<MetroStation> stations = line.getStations();
                if (stations.hasId(id)) return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasName(String name) {
        if (super.hasName(name)) {
            return true;
        } else {
            for (MetroLine line : toList()) {
                IDictionary<MetroStation> stations = line.getStations();
                if (stations.hasName(name)) return true;
            }
        }
        return false;
    }

    @Override
    public MetroLine getById(String id) {
        if (hasId(id)) {
            if (super.hasId(id)) {
                return super.getById(id);
            } else {
                for (MetroLine line : toList()) {
                    IDictionary<MetroStation> stations = line.getStations();
                    if (stations.hasId(id)) return stations.getById(id);
                }
            }
        }
        return nullObject;
    }

    @Override
    public MetroLine getByName(String name) {
        if (hasName(name)) {
            if (super.hasName(name)) {
                return super.getByName(name);
            } else {
                for (MetroLine line : toList()) {
                    IDictionary<MetroStation> stations = line.getStations();
                    if (stations.hasName(name)) return stations.getByName(name);
                }
            }
        }
        return nullObject;
    }
}
