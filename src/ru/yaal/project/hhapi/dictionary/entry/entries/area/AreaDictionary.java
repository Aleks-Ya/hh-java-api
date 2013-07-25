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
    public boolean hasId(String id) {
        if (super.hasId(id)) {
            return true;
        } else {
            for (Area area : toList()) {
                IDictionary<Area> areas = area.getAreas();
                if (areas.hasId(id)) return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasName(final String name) {
        if (super.hasName(name)) {
            return true;
        } else {
            for (Area area : toList()) {
                IDictionary<Area> areas = area.getAreas();
                if (areas.hasName(name)) return true;
            }
        }
        return false;
    }

    @Override
    public Area getById(String id) {
        if (super.hasId(id)) {
            return super.getById(id);
        } else {
            for (Area area : toList()) {
                IDictionary<Area> areas = area.getAreas();
                if (areas.hasId(id)) return areas.getById(id);
            }
        }
        return getNullObject(id);
    }

    @Override
    public Area getByName(String name) {
        if (super.hasName(name)) {
            return super.getByName(name);
        } else {
            for (Area area : toList()) {
                IDictionary<Area> areas = area.getAreas();
                if (areas.hasName(name)) return areas.getByName(name);
            }
        }
        return getNullObject(name);
    }
}
