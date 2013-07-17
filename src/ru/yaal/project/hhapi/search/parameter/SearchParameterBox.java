package ru.yaal.project.hhapi.search.parameter;

import ru.yaal.project.hhapi.search.SearchException;

import java.util.*;

public class SearchParameterBox {
    private final Map<SearchParamNames, List<String>> params = new HashMap<>();

    public SearchParameterBox() {
    }

    public SearchParameterBox(SearchParamNames name, String value) throws SearchException {
        addParameter(name, value);
    }

    public void addParameter(SearchParamNames name, String value) throws SearchException {
        if (!params.containsKey(name)) {
            params.put(name, new ArrayList<>(Arrays.asList(value)));
        } else {
            if (name.acceptMultipleVales()) {
                List<String> values = params.get(name);
                values.add(value);
            } else {
                throw new SearchException(
                        "Параметр поиска \"%s\" не позволяет добавлять более одного значения (попытка добавить \"%s\").",
                        name.getName(), value);
            }
        }
    }

    public Map<SearchParamNames, List<String>> getParameterMap() {
        return params;
    }
}
