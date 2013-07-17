package ru.yaal.project.hhapi.search.parameter;

import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchFields;

import java.util.HashMap;
import java.util.Map;

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
    public Map<SearchParamNames, String> getSearchParameters() {
        Map<SearchParamNames, String> params = new HashMap<>();
        params.put(SearchParamNames.TEXT, text);
        for (VacancySearchFields field : fields) {
            params.put(SearchParamNames.VACANCY_SEARCH_FIELDS, field.getId());
            //todo реализовать добавление нескольких параметров
        }
        return params;
    }

}
