package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.DictionaryException;

import java.util.List;

public class AreaList extends Dictionary<Area> {

    public AreaList(List<Area> treeList) throws DictionaryException {
        super(treeList);
    }

}
