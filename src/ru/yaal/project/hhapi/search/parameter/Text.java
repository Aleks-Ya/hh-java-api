package ru.yaal.project.hhapi.search.parameter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancySearchFields;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.SearchParameterBox;

import java.net.URLEncoder;

public class Text implements ISearchParameter {
    private static final Logger LOG = LoggerFactory.getLogger(Text.class);
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
        try {
            SearchParameterBox params = new SearchParameterBox();
            params.addParameter(SearchParamNames.TEXT, URLEncoder.encode(text, "UTF-8"));
            for (VacancySearchFields field : fields) {
                params.addParameter(SearchParamNames.VACANCY_SEARCH_FIELDS, field.getId());
            }
            return params;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new SearchException(e);
        }
    }

    @Override
    public String getSearchParameterName() {
        return "Текст";
    }

}
