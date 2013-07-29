package ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield;

import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

public class ProfessionalField extends AbstractDictionaryEntry implements ISearchParameter {
    public static final ProfessionalField NULL_PROFESSIONAL_FIELD = new ProfessionalField();
    public static final ProfessionalFieldDictionary PROFESSIONAL_FIELDS = Dictionaries.getInstance().getProfessionalFields();
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<Specialization> specializations;

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.PROFESSIONAL_FIELD, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "Профессиональная область";
    }
}
