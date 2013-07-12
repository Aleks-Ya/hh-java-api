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
    public static final Experience NO_EXPERIENCE = new Experience("noExperience", "��� �����");
    public static final Experience BETWEEN_1_AND_3 = new Experience("between1And3", "�� 1 ���� �� 3 ���");
    public static final Experience BETWEEN_3_AND_6 = new Experience("between3And6", "�� 3 �� 6 ���");
    public static final Experience MORE_THAN_6 = new Experience("moreThan6", "����� 6 ���");

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
