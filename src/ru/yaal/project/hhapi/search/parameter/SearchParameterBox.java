package ru.yaal.project.hhapi.search.parameter;

import java.util.*;

public class SearchParameterBox {
    private final Map<SearchParamNames, List<String>> params = new HashMap<>();

    public SearchParameterBox() {
    }

    public SearchParameterBox(SearchParamNames name, String value) {
        addParameter(name, value);
    }

    public void addParameter(SearchParamNames name, String value) {
        if (!params.containsKey(name)) {
            params.put(name, new ArrayList<>(Arrays.asList(value)));
        } else {
            List<String> values = params.get(name);
            values.add(value);
        }
    }

    public Map<SearchParamNames, List<String>> getParameterMap() {
        return params;
    }
}
