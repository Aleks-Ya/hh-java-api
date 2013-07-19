package ru.yaal.project.hhapi.search.parameter;

import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchFields;
import ru.yaal.project.hhapi.search.SearchException;

public class Text implements ISearchParameter {
    private String text = "";
    private VacancySearchFields[] fields = {};

    public Text(String text) {
        this.text = text;
    }

    public Text(String text, VacancySearchFields... fields) {
        this.text = text;
        this.fields = fields;
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        SearchParameterBox params = new SearchParameterBox();
        params.addParameter(SearchParamNames.TEXT, text);
        for (VacancySearchFields field : fields) {
            params.addParameter(SearchParamNames.VACANCY_SEARCH_FIELDS, field.getId());
        }
        return params;
    }

    @Override
    public String getSearchParameterName() {
        return "Текст";
    }

}
