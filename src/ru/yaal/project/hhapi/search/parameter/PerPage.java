package ru.yaal.project.hhapi.search.parameter;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PerPage implements ISearchParameter {
    private Integer perPage;

    public PerPage(Integer perPage) {
        this.perPage = perPage;
    }

    @Override
    public Map<SearchParamNames, String> getSearchParameters() {
        Map<SearchParamNames, String> params = new HashMap<>(1);
        params.put(SearchParamNames.PER_PAGE, String.valueOf(perPage));
        return params;
    }
}
