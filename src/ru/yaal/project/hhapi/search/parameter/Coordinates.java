package ru.yaal.project.hhapi.search.parameter;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Coordinates implements ISearchParameter {
    private Double topLat;
    private Double bottomLat;
    private Double rightLng;
    private Double leftLng;

    public Coordinates(Double topLat, Double bottomLat, Double leftLng, Double rightLng) {
        this.topLat = topLat;
        this.bottomLat = bottomLat;
        this.rightLng = rightLng;
        this.leftLng = leftLng;
    }

    @Override
    public Map<SearchParamNames, String> getSearchParameters() {
        Map<SearchParamNames, String> params = new HashMap<>(4);
        params.put(SearchParamNames.TOP_LAT, String.valueOf(topLat));
        params.put(SearchParamNames.BOTTOM_LAT, String.valueOf(bottomLat));
        params.put(SearchParamNames.RIGHT_LNG, String.valueOf(rightLng));
        params.put(SearchParamNames.LEFT_LNG, String.valueOf(leftLng));
        return params;
    }

}
