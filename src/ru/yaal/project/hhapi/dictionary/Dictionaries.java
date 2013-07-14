package ru.yaal.project.hhapi.dictionary;

import ru.yaal.project.hhapi.HhConstants;
import ru.yaal.project.hhapi.dictionary.entry.entries.*;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.AreaList;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroList;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalField;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancyLabel;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchFields;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchOrder;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancyType;
import ru.yaal.project.hhapi.loader.ContentLoader;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.LoadException;
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
    private AreaList areaCache;
    private MetroList metroCache;
    private IDictionary<ProfessionalField> professionalFieldCache;
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

    public static AreaList getArea() throws DictionaryException {
        init();
        dictionaries.loadAreas();
        return dictionaries.areaCache;
    }

    public static MetroList getMetro() throws DictionaryException {
        init();
        dictionaries.loadMetro();
        return dictionaries.metroCache;
    }

    public static IDictionary<ProfessionalField> getProfessionalField() throws DictionaryException {
        init();
        dictionaries.loadProfessionalFields();
        return dictionaries.professionalFieldCache;
    }

    private void loadAreas() throws DictionaryException {
        try {
            String content = loader.loadContent(HhConstants.AREAS_URL);
            IParser<AreaList> parse = new AreasParser();
            areaCache = parse.parse(content);
        } catch (Exception e) {
            throw new DictionaryException(e);
        }
    }

    private void loadMetro() throws DictionaryException {
        try {
            String content = loader.loadContent(HhConstants.METRO_URL);
            IParser<MetroList> parse = new MetroParser();
            metroCache = parse.parse(content);
        } catch (Exception e) {
            throw new DictionaryException(e);
        }
    }

    private void loadProfessionalFields() throws DictionaryException {
        try {
            String content = loader.loadContent(HhConstants.SPECIALIZATIONS_URL);
            IParser<IDictionary<ProfessionalField>> parse = new ProfessionalFieldsParser();
            professionalFieldCache = parse.parse(content);
        } catch (Exception e) {
            throw new DictionaryException(e);
        }
    }

    private void loadSmallDictionaries() throws DictionaryException {
        try {
            if (!isSmallDictionariesLoaded) {
                String content = loader.loadContent(HhConstants.DICTINARIES_URL);
                SmallDictionariesParser parse = new SmallDictionariesParser();
                DictionariesContainer dictionries = parse.parse(content);

                businessTripReadinessCache = new Dictionary<>(dictionries.getBusinessTripReadiness());
                currencyCache = new Dictionary<>(dictionries.getCurrency());
                educationLevelCache = new Dictionary<>(dictionries.getEducationLevel());
                employmentCache = new Dictionary<>(dictionries.getEmployment());
                experienceCache = new Dictionary<>(dictionries.getExperience());
                genderCache = new Dictionary<>(dictionries.getGender());
                languageLevelCache = new Dictionary<>(dictionries.getLanguageLevel());
                preferredContactTypeCache = new Dictionary<>(dictionries.getPreferredContactType());
                resumeAccessTypeCache = new Dictionary<>(dictionries.getResumeAccessType());
                employmentCache = new Dictionary<>(dictionries.getEmployment());
                siteLangCache = new Dictionary<>(dictionries.getSiteLang());
                travelTimeCache = new Dictionary<>(dictionries.getTravelTime());
                vacancyLabelCache = new Dictionary<>(dictionries.getVacancyLabel());
                vacancySearchFieldsCache = new Dictionary<>(dictionries.getVacancySearchFields());
                vacancySearchOrderCache = new Dictionary<>(dictionries.getVacancySearchOrder());
                vacancyTypeCache = new Dictionary<>(dictionries.getVacancyType());
                scheduleCache = new Dictionary<>(dictionries.getSchedule());

                isSmallDictionariesLoaded = true;
            }
        } catch (LoadException e) {
            throw new DictionaryException(e);
        }
    }

}
