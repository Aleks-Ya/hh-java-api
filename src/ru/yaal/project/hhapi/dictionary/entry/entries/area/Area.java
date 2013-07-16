package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString(callSuper = true)
public class Area extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Area NULL_AREA = new Area();
    @Getter
    @Setter
    @SerializedName("parent_id")
    private String parentId;
    @Getter
    @Setter
    private URL url;
    @Getter
    @Setter
    private List<Area> areas = new ArrayList<>(0);

    @Override
    public Map<SearchParamNames, String> getSearchParameters() throws SearchException {
        Map<SearchParamNames, String> params = new HashMap<>(1);
        params.put(SearchParamNames.AREA, getId());
        return params;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Area) {
            Area otherArea = (Area) other;
            return (getId().equals(otherArea.getId()));
        } else {
            return false;
        }
    }
}
