package ru.yaal.project.hhapi.dictionary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.*;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancyLabel;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancyType;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.parser.SmallDictionariesParser;

/**
 * Для подмены загрузчика классов на тестовый добавить параметр -Dfake_content_loader=ru.yaal.project.hhapi.loader.FakeContentLoader
 */
public class Dictionaries {
    private static final Logger LOG = LoggerFactory.getLogger(Dictionaries.class);
    private static Dictionaries dictionaries;
    private IDictionary<BusinessTripReadiness> businessTripReadinessCache = new Dictionary<>(BusinessTripReadiness.NULL_BUSINESS_TRIP_READINESS);
    private IDictionary<Experience> experienceCache = new Dictionary<>(Experience.NULL_EXPERIENCE);
    private IDictionary<LanguageLevel> languageLevelCache = new Dictionary<>(LanguageLevel.NULL_LANGUAGE_LEVEL);
    private IDictionary<PreferredContactType> preferredContactTypeCache = new Dictionary<>(PreferredContactType.NULL_PREFERRED_CONTACT_TYPE);
    private IDictionary<RelocationType> relocationTypeCache = new Dictionary<>(RelocationType.NULL_RELOCATION_TYPE);//todo похоже не парсится из /dictionaries
    private IDictionary<ResumeAccessType> resumeAccessTypeCache = new Dictionary<>(ResumeAccessType.NULL_RESUME_ACCESS_TYPE);
    private IDictionary<SiteLang> siteLangCache = new Dictionary<>(SiteLang.NULL_SITE_LANG);
    private IDictionary<SiteType> siteTypeCache = new Dictionary<>(SiteType.NULL_SITE_TYPE);//todo похоже не парсится из /dictionaries
    private IDictionary<TravelTime> travelTimeCache = new Dictionary<>(TravelTime.NULL_TRAVEL_TIME);
    private IDictionary<VacancyLabel> vacancyLabelCache = new Dictionary<>(VacancyLabel.NULL_VACANCY_LABEL);
    private IDictionary<VacancyType> vacancyTypeCache = new Dictionary<>(VacancyType.NULL_VACANCY_TYPE);
    private IContentLoader loader;
    private boolean isSmallDictionariesLoaded = false;

    private Dictionaries(IContentLoader loader) {
        this.loader = loader;
    }

    private static void init() {
        if (dictionaries == null) {
            LOG.info("Инициализирую словари.");
            dictionaries = new Dictionaries(ContentLoaderFactory.newInstanceLongTermCache());
        }
    }

    private void loadSmallDictionaries() {
        try {
            if (!isSmallDictionariesLoaded) {
                String content = loader.loadContent(UrlConstants.DICTINARIES_URL);
                SmallDictionariesParser parse = new SmallDictionariesParser();
                DictionariesContainer dictionries = parse.parse(content);

                businessTripReadinessCache = new Dictionary<>(dictionries.getBusinessTripReadiness(), BusinessTripReadiness.NULL_BUSINESS_TRIP_READINESS);
                experienceCache = new Dictionary<>(dictionries.getExperience(), Experience.NULL_EXPERIENCE);
                languageLevelCache = new Dictionary<>(dictionries.getLanguageLevel(), LanguageLevel.NULL_LANGUAGE_LEVEL);
                preferredContactTypeCache = new Dictionary<>(dictionries.getPreferredContactType(), PreferredContactType.NULL_PREFERRED_CONTACT_TYPE);
                resumeAccessTypeCache = new Dictionary<>(dictionries.getResumeAccessType(), ResumeAccessType.NULL_RESUME_ACCESS_TYPE);
                siteLangCache = new Dictionary<>(dictionries.getSiteLang(), SiteLang.NULL_SITE_LANG);
                travelTimeCache = new Dictionary<>(dictionries.getTravelTime(), TravelTime.NULL_TRAVEL_TIME);
                vacancyLabelCache = new Dictionary<>(dictionries.getVacancyLabel(), VacancyLabel.NULL_VACANCY_LABEL);
                vacancyTypeCache = new Dictionary<>(dictionries.getVacancyType(), VacancyType.NULL_VACANCY_TYPE);

                isSmallDictionariesLoaded = true;
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

}
