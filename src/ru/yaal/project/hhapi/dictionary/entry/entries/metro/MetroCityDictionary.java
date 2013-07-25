package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.IDictionary;

import java.util.List;

public class MetroCityDictionary extends Dictionary<MetroCity> {

    public MetroCityDictionary() {
        super(MetroStation.NULL_METRO_CITY);
    }

    public MetroCityDictionary(List<MetroCity> metroCities) throws DictionaryException {
        super(MetroStation.NULL_METRO_CITY);
        for (MetroCity metroCity : metroCities) {
            addEntry(metroCity);
        }
    }

    @Override
    public boolean hasId(String id) {
        if (super.hasId(id)) {
            return true;
        } else {
            for (MetroCity city : toList()) {
                IDictionary<MetroLine> lines = city.getLines();
                if (lines.hasId(id)) {
                    return true;
                } else {
                    for (MetroLine line : lines.toList()) {
                        IDictionary<MetroStation> stations = line.getStations();
                        if (stations.hasId(id)) return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasName(String name) {
        if (super.hasName(name)) {
            return true;
        } else {
            for (MetroCity city : toList()) {
                IDictionary<MetroLine> lines = city.getLines();
                if (lines.hasName(name)) {
                    return true;
                } else {
                    for (MetroLine line : lines.toList()) {
                        IDictionary<MetroStation> stations = line.getStations();
                        if (stations.hasName(name)) return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public MetroCity getById(String id) {
        if (hasId(id)) {
            if (super.hasId(id)) {
                return super.getById(id);
            } else {
                for (MetroCity city : toList()) {
                    IDictionary<MetroLine> lines = city.getLines();
                    if (lines.hasId(id)) {
                        return lines.getById(id);
                    } else {
                        for (MetroLine line : lines.toList()) {
                            IDictionary<MetroStation> stations = line.getStations();
                            if (stations.hasId(id)) return stations.getById(id);
                        }
                    }
                }
            }
        }
        return nullObject;
    }

    @Override
    public MetroCity getByName(String name) {
        if (hasName(name)) {
            if (super.hasName(name)) {
                return super.getByName(name);
            } else {
                for (MetroCity city : toList()) {
                    IDictionary<MetroLine> lines = city.getLines();
                    if (lines.hasName(name)) {
                        return lines.getByName(name);
                    } else {
                        for (MetroLine line : lines.toList()) {
                            IDictionary<MetroStation> stations = line.getStations();
                            if (stations.hasName(name)) return stations.getByName(name);
                        }
                    }
                }
            }
        }
        return nullObject;
    }
}
