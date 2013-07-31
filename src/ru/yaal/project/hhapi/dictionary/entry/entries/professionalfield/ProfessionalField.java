package ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield;

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
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.ISearchParameter;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;


public class ProfessionalField extends AbstractDictionaryEntry implements ISearchParameter {
    private static final Logger LOG = LoggerFactory.getLogger(ProfessionalField.class);
    public static final ProfessionalField NULL_PROFESSIONAL_FIELD = new ProfessionalField();
    public static final ProfessionalFieldDictionary PROFESSIONAL_FIELDS = loadProfessionalFields();
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<Specialization> specializations;

    private static ProfessionalFieldDictionary loadProfessionalFields() {
        ProfessionalFieldDictionary professionalFields;
        try {
            LOG.info("Загружаю справочник профессиональных областей.");
            IContentLoader loader = ContentLoaderFactory.newInstanceLongTermCache();
            String content = loader.loadContent(UrlConstants.SPECIALIZATIONS_URL);
            IParser<ProfessionalFieldDictionary> parse = new ProfessionalFieldsParser();
            professionalFields = parse.parse(content);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            professionalFields = new ProfessionalFieldDictionary();
        }
        return professionalFields;
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.PROFESSIONAL_FIELD, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "Профессиональная область";
    }
}
