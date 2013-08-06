package ru.yaal.project.hhapi.dictionary.entry.entries.area;

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

import java.net.URL;

/**
 * Район.
 * Может использоваться как параметр поиска вакансий. Допускает множественное значение ("ИЛИ").
 */
public class Area extends AbstractDictionaryEntry implements ISearchParameter {
    private static final Logger LOG = LoggerFactory.getLogger(Area.class);
    public static final Area NULL_AREA = new Area();
    public static final AreaDictionary AREAS = loadAreas();
    public static final Area MOSCOW = AREAS.getByName("Москва");
    public static final Area SAINT_PETERSBURG = AREAS.getByName("Санкт-Петербург");
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private Area parent;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private URL url;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<Area> areas;

    private static AreaDictionary loadAreas() {
        AreaDictionary areas;
        try {
            LOG.debug("Загружаю справочник районов.");
            IContentLoader loader = ContentLoaderFactory.newInstanceLongTermCache();
            String content = loader.loadContent(UrlConstants.AREAS_URL);
            IParser<AreaDictionary> parse = new AreasParser();
            areas = parse.parse(content);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            areas = new AreaDictionary();
        }
        return areas;
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.AREA, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "Регион";
    }

}
