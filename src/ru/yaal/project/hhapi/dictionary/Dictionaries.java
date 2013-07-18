package ru.yaal.project.hhapi.dictionary;

import ru.yaal.project.hhapi.dictionary.entry.entries.area.AreaDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.currency.Currency;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalFieldDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.*;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancyLabel;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchFields;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchOrder;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancyType;
import ru.yaal.project.hhapi.loader.ContentLoader;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.LoadException;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.parser.*;

public class Dictionaries {
    private static Dictionaries dictionaries;
    private IDictionary<BusinessTripReadiness> businessTripReadinessCache;
    private IDictionary<Currency> currencyCache;
    private IDictionary<EducationLevel> educationLevelCache;
    private IDictionary<Employment> employmentCache;
    private IDictionary<Experience> experienceCache;
    private IDictionary<Gender> genderCache;
    private IDictionary<LanguageLevel> languageLevelCache;
    private IDictionary<PreferredContactType> preferredContactTypeCache;
    private IDictionary<RelocationType> relocationTypeCache;
    private IDictionary<ResumeAccessType> resumeAccessTypeCache;
    private IDictionary<Schedule> scheduleCache;
    private IDictionary<SiteLang> siteLangCache;
    private IDictionary<SiteType> siteTypeCache;
    private IDictionary<TravelTime> travelTimeCache;
    private IDictionary<VacancyLabel> vacancyLabelCache;
    private IDictionary<VacancySearchFields> vacancySearchFieldsCache;
    private IDictionary<VacancySearchOrder> vacancySearchOrderCache;
    private IDictionary<VacancyType> vacancyTypeCache;
    private AreaDictionary areaCache;
    private MetroDictionary metroCache;
    private ProfessionalFieldDictionary professionalFieldCache;
    private IContentLoader loader;
    private boolean isSmallDictionariesLoaded = false;

    private Dictionaries(IContentLoader loader) {
        this.loader = loader;
    }

    private static void init() {
        if (dictionaries == null) dictionaries = new Dictionaries(new ContentLoader());
    }

    /**
     * Подмена загрузчика контента нужна для модульного тестирования. Используйте #getInstance().
     */
    public static void setLoader(IContentLoader loader) throws DictionaryException {
        init();
        dictionaries.loader = loader;
    }

    @Deprecated
    public static IDictionary<Schedule> getSchedule() throws DictionaryException {
        init();
        dictionaries.loadSmallDictionaries();
        return dictionaries.scheduleCache;
    }

    public static IDictionary<Currency> getCurrency() throws DictionaryException {
        init();
        dictionaries.loadSmallDictionaries();
        return dictionaries.currencyCache;
    }

    public static IDictionary<EducationLevel> getEducationLevel() throws DictionaryException {
        init();
        dictionaries.loadSmallDictionaries();
        return dictionaries.educationLevelCache;
    }

    @Deprecated
    public static IDictionary<VacancySearchOrder> getVacancySearchOrder() throws DictionaryException {
        init();
        dictionaries.loadSmallDictionaries();
        return dictionaries.vacancySearchOrderCache;
    }

    @Deprecated
    public static IDictionary<Experience> getExperience() throws DictionaryException {
        init();
        dictionaries.loadSmallDictionaries();
        return dictionaries.experienceCache;
    }

    public static AreaDictionary getArea() {
        init();
        dictionaries.loadAreas();
        return dictionaries.areaCache;
    }

    public static MetroDictionary getMetro() {
        init();
        dictionaries.loadMetro();
        return dictionaries.metroCache;
    }

    public static ProfessionalFieldDictionary getProfessionalField() throws DictionaryException {
        init();
        dictionaries.loadProfessionalFields();
        return dictionaries.professionalFieldCache;
    }

    private void loadAreas() {
        try {
            String content = loader.loadContent(UrlConstants.AREAS_URL);
            IParser<AreaDictionary> parse = new AreasParser();
            areaCache = parse.parse(content);
        } catch (Exception e) {
            areaCache = new AreaDictionary();
        }
    }

    private void loadMetro() {
        try {
            String content = loader.loadContent(UrlConstants.METRO_URL);
            IParser<MetroDictionary> parse = new MetroParser();
            metroCache = parse.parse(content);
        } catch (Exception e) {
            metroCache = new MetroDictionary();
        }
    }

    private void loadProfessionalFields() throws DictionaryException {
        try {
            String content = loader.loadContent(UrlConstants.SPECIALIZATIONS_URL);
            IParser<ProfessionalFieldDictionary> parse = new ProfessionalFieldsParser();
            professionalFieldCache = parse.parse(content);
        } catch (Exception e) {
            throw new DictionaryException(e);
        }
    }

    private void loadSmallDictionaries() throws DictionaryException {
        try {
            if (!isSmallDictionariesLoaded) {
                String content = loader.loadContent(UrlConstants.DICTINARIES_URL);
                SmallDictionariesParser parse = new SmallDictionariesParser();
                DictionariesContainer dictionries = parse.parse(content);

                businessTripReadinessCache = new Dictionary<>(dictionries.getBusinessTripReadiness(), BusinessTripReadiness.NULL_BUSINESS_TRIP_READINESS);
                currencyCache = new Dictionary<>(dictionries.getCurrency(), Currency.NULL_CURRENCY);
                educationLevelCache = new Dictionary<>(dictionries.getEducationLevel(), EducationLevel.NULL_EDUCATION_LEVEL);
                employmentCache = new Dictionary<>(dictionries.getEmployment(), Employment.NULL_EMPLOYMENT);
                experienceCache = new Dictionary<>(dictionries.getExperience(), Experience.NULL_EXPERIENCE);
                genderCache = new Dictionary<>(dictionries.getGender(), Gender.NULL_GENDER);
                languageLevelCache = new Dictionary<>(dictionries.getLanguageLevel(), LanguageLevel.NULL_LANGUAGE_LEVEL);
                preferredContactTypeCache = new Dictionary<>(dictionries.getPreferredContactType(), PreferredContactType.NULL_PREFERRED_CONTACT_TYPE);
                resumeAccessTypeCache = new Dictionary<>(dictionries.getResumeAccessType(), ResumeAccessType.NULL_RESUME_ACCESS_TYPE);
                employmentCache = new Dictionary<>(dictionries.getEmployment(), Employment.NULL_EMPLOYMENT);
                siteLangCache = new Dictionary<>(dictionries.getSiteLang(), SiteLang.NULL_SITE_LANG);
                travelTimeCache = new Dictionary<>(dictionries.getTravelTime(), TravelTime.NULL_TRAVEL_TIME);
                vacancyLabelCache = new Dictionary<>(dictionries.getVacancyLabel(), VacancyLabel.NULL_VACANCY_LABEL);
                vacancySearchFieldsCache = new Dictionary<>(dictionries.getVacancySearchFields(), VacancySearchFields.NULL_VACANCY_SEARCH_FIELD);
                vacancySearchOrderCache = new Dictionary<>(dictionries.getVacancySearchOrder(), VacancySearchOrder.NULL_VACANCY_SEARCH_ORDER);
                vacancyTypeCache = new Dictionary<>(dictionries.getVacancyType(), VacancyType.NULL_VACANCY_TYPE);
                scheduleCache = new Dictionary<>(dictionries.getSchedule(), Schedule.NULL_SCHEDULE);

                isSmallDictionariesLoaded = true;
            }
        } catch (LoadException e) {
            throw new DictionaryException(e);
        }
    }

}
