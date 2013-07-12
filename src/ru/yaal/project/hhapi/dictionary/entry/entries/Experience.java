package ru.yaal.project.hhapi.dictionary.entry.entries;

import lombok.Data;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;

import java.util.HashMap;
import java.util.Map;

@Data
public class Experience extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Experience NO_EXPERIENCE = new Experience("noExperience", "Нет опыта");
    public static final Experience BETWEEN_1_AND_3 = new Experience("between1And3", "От 1 года до 3 лет");
    public static final Experience BETWEEN_3_AND_6 = new Experience("between3And6", "От 3 до 6 лет");
    public static final Experience MORE_THAN_6 = new Experience("moreThan6", "Более 6 лет");

    public Experience() {
    }

    public Experience(String id, String name) {
        setId(id);
        setName(name);
    }

    @Override
    public Map<SearchParamNames, String> getSearchParameters() throws SearchException {
        Map<SearchParamNames, String> params = new HashMap<>(1);
        params.put(SearchParamNames.EXPERIENCE, getId());
        return params;
    }
}
