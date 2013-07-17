package ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield;

import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;

import java.util.HashMap;
import java.util.Map;

public class ProfessionalField extends AbstractDictionaryEntry implements ISearchParameter {
    public static final ProfessionalField NULL_PROFESSIONAL_FIELD = new ProfessionalField();
    @Getter @Setter
    protected IDictionary<Specialization> specializations;

    @Override
    public Map<SearchParamNames, String> getSearchParameters() throws SearchException {
        Map<SearchParamNames, String> params = new HashMap<>(1);
        params.put(SearchParamNames.PROFESSIONAL_FIELD, getId());
        return params;
    }
}
