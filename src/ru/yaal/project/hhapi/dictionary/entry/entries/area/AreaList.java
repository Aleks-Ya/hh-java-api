package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import ru.yaal.project.hhapi.dictionary.entry.TreeDictionary;

import java.util.ArrayList;
import java.util.List;

public class AreaList extends TreeDictionary<Area> {

    public AreaList(List<Area> treeList) {
        super(treeList);
    }

    @Override
    protected List<Area> treeToFlat(List<Area> treeList) {
        List<Area> result = new ArrayList<>(treeList);
        for (Area area : treeList) {
            List<Area> nestedAreas = area.getAreas();
            List<Area> flatNestedAreasList = treeToFlat(nestedAreas);
            result.addAll(flatNestedAreasList);
        }
        return result;
    }

}
