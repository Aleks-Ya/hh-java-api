package ru.yaal.project.hhapi.dictionary;

import ru.yaal.project.hhapi.HhConstants;
import ru.yaal.project.hhapi.dictionary.entry.entries.*;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalField;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancyLabel;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchFields;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchOrder;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancyType;
import ru.yaal.project.hhapi.loader.ContentLoader;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.LoadException;
import ru.yaal.project.hhapi.parser.AreasParser;
import ru.yaal.project.hhapi.parser.IParser;
import ru.yaal.project.hhapi.parser.ProfessionalFieldsParser;
import ru.yaal.project.hhapi.parser.SmallDictionariesParser;

import java.util.List;

public class Dictionaries {
    private static Dictionaries dictionaries;
    public Dictionary<BusinessTripReadiness> businessTripReadinessCache;
    public Dictionary<Currency> currencyCache;
    public Dictionary<EducationLevel> educationLevelCache;
    public Dictionary<Employment> employmentCache;
    public Dictionary<Experience> experienceCache;
    public Dictionary<Gender> genderCache;
    public Dictionary<LanguageLevel> languageLevelCache;
    public Dictionary<PreferredContactType> preferredContactTypeCache;
    public Dictionary<RelocationType> relocationTypeCache;
    public Dictionary<ResumeAccessType> resumeAccessTypeCache;
    public Dictionary<Schedule> scheduleCache;
    public Dictionary<SiteLang> siteLangCache;
    public Dictionary<SiteType> siteTypeCache;
    public Dictionary<TravelTime> travelTimeCache;
    public Dictionary<VacancyLabel> vacancyLabelCache;
    public Dictionary<VacancySearchFields> vacancySearchFieldsCache;
    public Dictionary<VacancySearchOrder> vacancySearchOrderCache;
    public Dictionary<VacancyType> vacancyTypeCache;
    public Dictionary<Area> areaCache;
    public Dictionary<ProfessionalField> professionalFieldCache;
    private IContentLoader loader;

    private Dictionaries(IContentLoader loader) throws DictionaryException {
        this.loader = loader;
        loadSmallDictionaries();
        loadAreas();
        loadProfessionalFields();
    }

    public static Dictionaries getInstance() throws DictionaryException {
        return getInstance(new ContentLoader());
    }

    /**
     * Подмена загрузчика контента нужна для модульного тестирования. Используйте #getInstance().
     */
    public static Dictionaries getInstance(IContentLoader loader) throws DictionaryException {
        if (dictionaries == null) {
            dictionaries = new Dictionaries(loader);
        }
        return dictionaries;
    }

    private void loadAreas() throws DictionaryException {
        try {
            String content = loader.loadContent(HhConstants.AREAS_URL);
            IParser<List<Area>> parse = new AreasParser();
            areaCache = new Dictionary<>(parse.parse(content));
        } catch (Exception e) {
            throw new DictionaryException(e);
        }
    }

    private void loadProfessionalFields() throws DictionaryException {
        try {
            String content = loader.loadContent(HhConstants.SPECIALIZATIONS_URL);
            IParser<List<ProfessionalField>> parse = new ProfessionalFieldsParser();
            professionalFieldCache = new Dictionary<>(parse.parse(content));
        } catch (LoadException e) {
            throw new DictionaryException(e);
        }
    }

    private void loadSmallDictionaries() throws DictionaryException {
        try {
            String content = loader.loadContent(HhConstants.DICTINARIES_URL);
            SmallDictionariesParser parse = new SmallDictionariesParser();
            DictionariesContainer dictionries = parse.parse(content);
            businessTripReadinessCache = new Dictionary<>(dictionries.getBusiness_trip_readiness());
            currencyCache = new Dictionary<>(dictionries.getCurrency());
            educationLevelCache = new Dictionary<>(dictionries.getEducation_level());
            employmentCache = new Dictionary<>(dictionries.getEmployment());
            experienceCache = new Dictionary<>(dictionries.getExperience());
            genderCache = new Dictionary<>(dictionries.getGender());
            languageLevelCache = new Dictionary<>(dictionries.getLanguage_level());
            preferredContactTypeCache = new Dictionary<>(dictionries.getPreferred_contact_type());
            resumeAccessTypeCache = new Dictionary<>(dictionries.getResume_access_type());
            employmentCache = new Dictionary<>(dictionries.getEmployment());
            siteLangCache = new Dictionary<>(dictionries.getSite_lang());
            travelTimeCache = new Dictionary<>(dictionries.getTravel_time());
            vacancyLabelCache = new Dictionary<>(dictionries.getVacancy_label());
            vacancySearchFieldsCache = new Dictionary<>(dictionries.getVacancy_search_fields());
            vacancyTypeCache = new Dictionary<>(dictionries.getVacancy_type());
            scheduleCache = new Dictionary<>(dictionries.getSchedule());
        } catch (LoadException e) {
            throw new DictionaryException(e);
        }
    }

}
