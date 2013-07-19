package ru.yaal.project.hhapi.dictionary.entry.entries.simple;

import lombok.Data;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

@Data
public class Experience extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Experience NULL_EXPERIENCE = new Experience();
    public static final Experience NO_EXPERIENCE = Dictionaries.getExperience().getEntryById("noExperience");
    public static final Experience BETWEEN_1_AND_3 = Dictionaries.getExperience().getEntryById("between1And3");
    public static final Experience BETWEEN_3_AND_6 = Dictionaries.getExperience().getEntryById("between3And6");
    public static final Experience MORE_THAN_6 = Dictionaries.getExperience().getEntryById("moreThan6");

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.EXPERIENCE, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "Опыт работы";
    }
}
