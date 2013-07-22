package ru.yaal.project.hhapi.dictionary;

import ru.yaal.project.hhapi.dictionary.entry.entries.area.AreaDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.currency.Currency;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCityDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalFieldDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.*;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancyLabel;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchFields;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchOrder;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancyType;
import ru.yaal.project.hhapi.loader.ContentLoader;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.parser.*;

/**
 * Для подмены загрузчика классов на тестовый добавить параметр -Dfake_content_loader=ru.yaal.project.hhapi.loader.FakeContentLoader
 */
public class Dictionaries {
    private static Dictionaries dictionaries;
    private IDictionary<BusinessTripReadiness> businessTripReadinessCache = new Dictionary<>(BusinessTripReadiness.NULL_BUSINESS_TRIP_READINESS);
    private IDictionary<Currency> currencyCache = new Dictionary<>(Currency.NULL_CURRENCY);
    private IDictionary<EducationLevel> educationLevelCache = new Dictionary<>(EducationLevel.NULL_EDUCATION_LEVEL);
    private IDictionary<Employment> employmentCache = new Dictionary<>(Employment.NULL_EMPLOYMENT);
    private IDictionary<Experience> experienceCache = new Dictionary<>(Experience.NULL_EXPERIENCE);
    private IDictionary<Gender> genderCache = new Dictionary<>(Gender.NULL_GENDER);
    private IDictionary<LanguageLevel> languageLevelCache = new Dictionary<>(LanguageLevel.NULL_LANGUAGE_LEVEL);
    private IDictionary<PreferredContactType> preferredContactTypeCache = new Dictionary<>(PreferredContactType.NULL_PREFERRED_CONTACT_TYPE);
    private IDictionary<RelocationType> relocationTypeCache = new Dictionary<>(RelocationType.NULL_RELOCATION_TYPE);//todo похоже не парсится из /dictionaries
    private IDictionary<ResumeAccessType> resumeAccessTypeCache = new Dictionary<>(ResumeAccessType.NULL_RESUME_ACCESS_TYPE);
    private IDictionary<Schedule> scheduleCache = new Dictionary<>(Schedule.NULL_SCHEDULE);
    private IDictionary<SiteLang> siteLangCache = new Dictionary<>(SiteLang.NULL_SITE_LANG);
    private IDictionary<SiteType> siteTypeCache = new Dictionary<>(SiteType.NULL_SITE_TYPE);//todo похоже не парсится из /dictionaries
    private IDictionary<TravelTime> travelTimeCache = new Dictionary<>(TravelTime.NULL_TRAVEL_TIME);
    private IDictionary<VacancyLabel> vacancyLabelCache = new Dictionary<>(VacancyLabel.NULL_VACANCY_LABEL);
    private IDictionary<VacancySearchFields> vacancySearchFieldsCache = new Dictionary<>(VacancySearchFields.NULL_VACANCY_SEARCH_FIELD);
    private IDictionary<VacancySearchOrder> vacancySearchOrderCache = new Dictionary<>(VacancySearchOrder.NULL_VACANCY_SEARCH_ORDER);
    private IDictionary<VacancyType> vacancyTypeCache = new Dictionary<>(VacancyType.NULL_VACANCY_TYPE);
    private AreaDictionary areaCache = new AreaDictionary();
    private MetroCityDictionary metroCache = new MetroCityDictionary();
    private ProfessionalFieldDictionary professionalFieldCache = new ProfessionalFieldDictionary();
    private IContentLoader loader;
    private boolean isSmallDictionariesLoaded = false;

    private Dictionaries(IContentLoader loader) {
        this.loader = loader;
    }

    private static void init() {
        if (dictionaries == null) {
            String fakeContentLoaderName = System.getProperty("content_loader");
            if (fakeContentLoaderName == null) {
                dictionaries = new Dictionaries(new ContentLoader());
            } else {
                try {
                    Class fakeContentLoaderClass = Class.forName(fakeContentLoaderName);
                    IContentLoader contentLoader = (IContentLoader) fakeContentLoaderClass.newInstance();
                    dictionaries = new Dictionaries(contentLoader);
                } catch (Exception e) {
                    dictionaries = new Dictionaries(new ContentLoader());
                }
            }
        }
    }

    public static IDictionary<Schedule> getSchedule() {
        init();
        dictionaries.loadSmallDictionaries();
        return dictionaries.scheduleCache;
    }

    public static IDictionary<Currency> getCurrency() {
        init();
        dictionaries.loadSmallDictionaries();
        return dictionaries.currencyCache;
    }

    public static IDictionary<EducationLevel> getEducationLevel() {
        init();
        dictionaries.loadSmallDictionaries();
        return dictionaries.educationLevelCache;
    }

    public static IDictionary<Gender> getGender() {
        init();
        dictionaries.loadSmallDictionaries();
        return dictionaries.genderCache;
    }

    public static IDictionary<Employment> getEmployment() {
        init();
        dictionaries.loadSmallDictionaries();
        return dictionaries.employmentCache;
    }

    public static IDictionary<VacancySearchOrder> getVacancySearchOrder() {
        init();
        dictionaries.loadSmallDictionaries();
        return dictionaries.vacancySearchOrderCache;
    }

    public static IDictionary<VacancySearchFields> getVacancySearchFields() {
        init();
        dictionaries.loadSmallDictionaries();
        return dictionaries.vacancySearchFieldsCache;
    }

    public static IDictionary<Experience> getExperience() {
        init();
        dictionaries.loadSmallDictionaries();
        return dictionaries.experienceCache;
    }

    public static AreaDictionary getArea() {
        init();
        dictionaries.loadAreas();
        return dictionaries.areaCache;
    }

    public static MetroCityDictionary getMetro() {
        init();
        dictionaries.loadMetro();
        return dictionaries.metroCache;
    }

    public static ProfessionalFieldDictionary getProfessionalField() {
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
            IParser<MetroCityDictionary> parse = new MetroParser();
            metroCache = parse.parse(content);
        } catch (Exception e) {
            metroCache = new MetroCityDictionary();
        }
    }

    private void loadProfessionalFields() {
        try {
            String content = loader.loadContent(UrlConstants.SPECIALIZATIONS_URL);
            IParser<ProfessionalFieldDictionary> parse = new ProfessionalFieldsParser();
            professionalFieldCache = parse.parse(content);
        } catch (Exception e) {
            professionalFieldCache = new ProfessionalFieldDictionary();
        }
    }

    private void loadSmallDictionaries() {
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
        } catch (Exception e) {
            //todo сообщение в лог
        }
    }

}
