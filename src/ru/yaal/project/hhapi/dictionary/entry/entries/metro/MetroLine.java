package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

public class MetroLine extends MetroCity implements ISearchParameter {
    public static final MetroLine NULL_METRO_LINE = new MetroLine();
    @Getter
    @Setter
    private String hexColor;
    @Getter
    @Setter
    private IDictionary<MetroStation> stations;
    @Getter
    @Setter
    private MetroCity city;

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.METRO, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "Линия метро";
    }
}
