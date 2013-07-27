package ru.yaal.project.hhapi.dictionary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.AreaDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.currency.Currency;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCityDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalFieldDictionary;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.parser.*;

public class Dictionaries2 {
    private static final Logger LOG = LoggerFactory.getLogger(Dictionaries2.class);
    private static Dictionaries2 dictionary;
    private IContentLoader loader = ContentLoaderFactory.newInstanceLongTermCache();
    private AreaDictionary areas;
    private MetroCityDictionary metroCities;
    private ProfessionalFieldDictionary professionalFields;
    private DictionariesContainer smallDictionaries;
    private IDictionary<Currency> currency;

    private Dictionaries2() {
        LOG.debug("Создаю инстанс Dictionaries2");
    }

    public static Dictionaries2 getInstance() {
        if (dictionary == null) dictionary = new Dictionaries2();
        return dictionary;
    }

    public AreaDictionary getAreas() {
        if (areas == null) loadAreas();
        return areas;
    }

    private void loadAreas() {
        try {
            LOG.info("Загружаю справочник районов.");
            String content = loader.loadContent(UrlConstants.AREAS_URL);
            IParser<AreaDictionary> parse = new AreasParser();
            areas = parse.parse(content);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            areas = new AreaDictionary();
        }
    }

    public MetroCityDictionary getMetroCities() {
        if (metroCities == null) loadMetro();
        return metroCities;
    }

    private void loadMetro() {
        try {
            LOG.info("Загружаю справочник метро.");
            String content = loader.loadContent(UrlConstants.METRO_URL);
            IParser<MetroCityDictionary> parse = new MetroParser();
            metroCities = parse.parse(content);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            metroCities = new MetroCityDictionary();
        }
    }

    public ProfessionalFieldDictionary getProfessionalFields() {
        if (professionalFields == null) loadProfessionalFields();
        return professionalFields;
    }

    private void loadProfessionalFields() {
        try {
            LOG.info("Загружаю справочник профессиональных областей.");
            String content = loader.loadContent(UrlConstants.SPECIALIZATIONS_URL);
            IParser<ProfessionalFieldDictionary> parse = new ProfessionalFieldsParser();
            professionalFields = parse.parse(content);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            professionalFields = new ProfessionalFieldDictionary();
        }
    }

    public IDictionary<Currency> getCurrency() {
        loadSmallDictionaries();
        return currency;
    }

    private void loadSmallDictionaries() {
        try {
            if (smallDictionaries == null) {
                String content = loader.loadContent(UrlConstants.DICTINARIES_URL);
                SmallDictionariesParser parse = new SmallDictionariesParser();
                smallDictionaries = parse.parse(content);

                currency = new Dictionary<>(smallDictionaries.getCurrency(), Currency.NULL_CURRENCY);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }


}
