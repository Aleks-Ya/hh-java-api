package ru.yaal.project.hhapi.search.parameter;

import lombok.Data;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.SearchParameterBox;

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
    public SearchParameterBox getSearchParameters() throws SearchException {
        SearchParameterBox params = new SearchParameterBox();
        params.addParameter(SearchParamNames.TOP_LAT, String.valueOf(topLat));
        params.addParameter(SearchParamNames.BOTTOM_LAT, String.valueOf(bottomLat));
        params.addParameter(SearchParamNames.RIGHT_LNG, String.valueOf(rightLng));
        params.addParameter(SearchParamNames.LEFT_LNG, String.valueOf(leftLng));
        return params;
    }

    @Override
    public String getSearchParameterName() {
        return "Географические координаты";
    }

}
