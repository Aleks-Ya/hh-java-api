package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

/**
 * Опыт работы (вакансия).
 */
public class Experience extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Experience NULL_EXPERIENCE = new Experience();
    public static final IDictionary<Experience> EXPERIENCES = SmallDictionariesInitializer.getInstance().getExperience();
    /**
     * Нет опыта.
     */
    public static final Experience NO_EXPERIENCE = EXPERIENCES.getById("noExperience");
    /**
     * От 1 года до 3 лет.
     */
    public static final Experience BETWEEN_1_AND_3 = EXPERIENCES.getById("between1And3");
    /**
     * От 3 до 6 лет.
     */
    public static final Experience BETWEEN_3_AND_6 = EXPERIENCES.getById("between3And6");
    /**
     * Более 6 лет.
     */
    public static final Experience MORE_THAN_6 = EXPERIENCES.getById("moreThan6");

    private Experience() {
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.EXPERIENCE, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "Опыт работы";
    }
}
