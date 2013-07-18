package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.IDictionary;

import java.util.List;

public class AreaDictionary extends Dictionary<Area> {

    public AreaDictionary() {
        super(Area.NULL_AREA);
    }

    public AreaDictionary(List<Area> treeList) throws DictionaryException {
        super(treeList, Area.NULL_AREA);
    }

    @Override
    public boolean hasEntryWithId(String id) {
        if (super.hasEntryWithId(id)) {
            return true;
        } else {
            for (Area area : toList()) {
                IDictionary<Area> areas = area.getAreas();
                if (areas.hasEntryWithId(id)) return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasEntryWithName(final String name) {
        if (super.hasEntryWithName(name)) {
            return true;
        } else {
            for (Area area : toList()) {
                IDictionary<Area> areas = area.getAreas();
                if (areas.hasEntryWithName(name)) return true;
            }
        }
        return false;
    }

    @Override
    public Area getEntryById(String id) {
        if (super.hasEntryWithId(id)) {
            return super.getEntryById(id);
        } else {
            for (Area area : toList()) {
                IDictionary<Area> areas = area.getAreas();
                if (areas.hasEntryWithId(id)) return areas.getEntryById(id);
            }
        }
        return nullObject;
    }

    @Override
    public Area getEntryByName(String name) {
        if (super.hasEntryWithName(name)) {
            return super.getEntryByName(name);
        } else {
            for (Area area : toList()) {
                IDictionary<Area> areas = area.getAreas();
                if (areas.hasEntryWithName(name)) return areas.getEntryByName(name);
            }
        }
        return nullObject;
    }
}
