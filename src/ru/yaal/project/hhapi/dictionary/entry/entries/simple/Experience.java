package ru.yaal.project.hhapi.dictionary.entry.entries.simple;

import lombok.Data;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

import java.util.HashMap;
import java.util.Map;

@Data
public class Experience extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Experience NULL_EXPERIENCE = new Experience();
    public static final Experience NO_EXPERIENCE = new Experience("noExperience", "Нет опыта");
    public static final Experience BETWEEN_1_AND_3 = new Experience("between1And3", "От 1 года до 3 лет");
    public static final Experience BETWEEN_3_AND_6 = new Experience("between3And6", "От 3 до 6 лет");
    public static final Experience MORE_THAN_6 = new Experience("moreThan6", "Более 6 лет");

    public Experience() {
    }

    public Experience(String id, String name) {
        super(id, name);
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.EXPERIENCE, getId());
    }
}
