package ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import lombok.Data;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;

@Data
public class ProfessionalField extends AbstractDictionaryEntry implements ISearchParameter{
	protected List<Specialization> specializations;

    @Override
    public Map<SearchParamNames, String> getSearchParameters() throws SearchException {
        Map<SearchParamNames, String> params = new HashMap<>(1);
        params.put(SearchParamNames.PROFESSIONAL_FIELD, getId());
        return params;
    }
}
