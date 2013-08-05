package ru.yaal.project.hhapi.dictionary.entry.entries.proffield;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.parser.IParser;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.SearchParameterBox;

/**
 * Профессиональная область.
 * Может использоваться как параметр поиска вакансий. Допускает множественное значение ("ИЛИ").
 */
public class ProfField extends AbstractDictionaryEntry implements ISearchParameter {
    private static final Logger LOG = LoggerFactory.getLogger(ProfField.class);
    public static final ProfField NULL_PROF_FIELD = new ProfField();
    public static final ProfFieldDictionary PROF_FIELDS = loadProfFields();
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<Specialization> specializations;

    private static ProfFieldDictionary loadProfFields() {
        ProfFieldDictionary profFields;
        try {
            LOG.info("Загружаю справочник профессиональных областей.");
            IContentLoader loader = ContentLoaderFactory.newInstanceLongTermCache();
            String content = loader.loadContent(UrlConstants.SPECIALIZATIONS_URL);
            IParser<ProfFieldDictionary> parse = new ProfFieldsParser();
            profFields = parse.parse(content);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            profFields = new ProfFieldDictionary();
        }
        return profFields;
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.PROF_FIELD, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "Профессиональная область";
    }
}
