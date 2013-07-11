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
    private Dictionary<BusinessTripReadiness> businessTripReadinessCache;
    private Dictionary<Currency> currencyCache;
    private Dictionary<EducationLevel> educationLevelCache;
    private Dictionary<Employment> employmentCache;
    private Dictionary<Experience> experienceCache;
    private Dictionary<Gender> genderCache;
    private Dictionary<LanguageLevel> languageLevelCache;
    private Dictionary<PreferredContactType> preferredContactTypeCache;
    private Dictionary<RelocationType> relocationTypeCache;
    private Dictionary<ResumeAccessType> resumeAccessTypeCache;
    private Dictionary<Schedule> scheduleCache;
    private Dictionary<SiteLang> siteLangCache;
    private Dictionary<SiteType> siteTypeCache;
    private Dictionary<TravelTime> travelTimeCache;
    private Dictionary<VacancyLabel> vacancyLabelCache;
    private Dictionary<VacancySearchFields> vacancySearchFieldsCache;
    private Dictionary<VacancySearchOrder> vacancySearchOrderCache;
    private Dictionary<VacancyType> vacancyTypeCache;
    private Dictionary<Area> areaCache;
    private Dictionary<ProfessionalField> professionalFieldCache;
    private IContentLoader loader;
    private boolean isSmallDictionariesLoaded = false;

    private Dictionaries(IContentLoader loader) throws DictionaryException {
        this.loader = loader;
    }

    private static void init() throws DictionaryException {
        if (dictionaries == null) dictionaries = new Dictionaries(new ContentLoader());
    }

    /**
     * Подмена загрузчика контента нужна для модульного тестирования. Используйте #getInstance().
     */
    public static void setLoader(IContentLoader loader) throws DictionaryException {
        init();
        dictionaries.loader = loader;
    }

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

    public static IDictionary<Area> getArea() throws DictionaryException {
        init();
        dictionaries.loadAreas();
        return dictionaries.areaCache;
    }

    public static IDictionary<ProfessionalField> getProfessionalField() throws DictionaryException {
        init();
        dictionaries.loadProfessionalFields();
        return dictionaries.professionalFieldCache;
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
            if (!isSmallDictionariesLoaded) {
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

                isSmallDictionariesLoaded = true;
            }
        } catch (LoadException e) {
            throw new DictionaryException(e);
        }
    }

}
