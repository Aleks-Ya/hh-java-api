package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.employer.EmployerType;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.UrlConstants;

public final class SmallDictionariesInitializer {
    private static final Logger LOG = LoggerFactory.getLogger(SmallDictionariesInitializer.class);
    private static SmallDictionariesInitializer dictionary;
    private IContentLoader loader = ContentLoaderFactory.newInstanceLongTermCache();
    private IDictionary<Currency> currency;
    private IDictionary<Gender> gender;
    private IDictionary<Schedule> schedule;
    private IDictionary<EducationLevel> educationLevel;
    private IDictionary<Employment> employment;
    private IDictionary<Order> order;
    private IDictionary<VacancySearchFields> vacancySearchFields;
    private IDictionary<Experience> experience;
    private IDictionary<EmployerType> employerType;
    private IDictionary<Label> label;
    private IDictionary<BusinessTripReadiness> businessTripReadiness;
    private IDictionary<LanguageLevel> languageLevel;
    private IDictionary<PreferredContactType> preferredContactType;
    private IDictionary<RelocationType> relocationType;
    private IDictionary<ResumeAccessType> resumeAccessType;
    private IDictionary<ResumeContactsSiteType> resumeContactsSiteType;
    private IDictionary<TravelTime> travelTime;
    private IDictionary<SiteLang> siteLang;
    private IDictionary<VacancyType> vacancyType;

    private SmallDictionariesInitializer() {
        LOG.debug("Создаю инстанс SmallDictionariesInitializer");
        loadSmallDictionaries();
    }

    public static synchronized SmallDictionariesInitializer getInstance() {
        if (dictionary == null) {
            dictionary = new SmallDictionariesInitializer();
        }
        return dictionary;
    }

    public IDictionary<Currency> getCurrency() {
        return currency;
    }

    public IDictionary<EmployerType> getEmployerType() {
        return employerType;
    }

    public IDictionary<Gender> getGender() {
        return gender;
    }

    public IDictionary<Schedule> getSchedule() {
        return schedule;
    }

    public IDictionary<EducationLevel> getEducationLevel() {
        return educationLevel;
    }

    public IDictionary<Employment> getEmployment() {
        return employment;
    }

    public IDictionary<Order> getOrder() {
        return order;
    }

    public IDictionary<VacancySearchFields> getVacancySearchFields() {
        return vacancySearchFields;
    }

    public IDictionary<Experience> getExperience() {
        return experience;
    }

    public IDictionary<Label> getLabel() {
        return label;
    }

    public IDictionary<BusinessTripReadiness> getBusinessTripReadiness() {
        return businessTripReadiness;
    }

    public IDictionary<LanguageLevel> getLanguageLevel() {
        return languageLevel;
    }

    public IDictionary<PreferredContactType> getPreferredContactType() {
        return preferredContactType;
    }

    public IDictionary<RelocationType> getRelocationType() {
        return relocationType;
    }

    public IDictionary<ResumeAccessType> getResumeAccessType() {
        return resumeAccessType;
    }

    public IDictionary<ResumeContactsSiteType> getResumeContactsSiteType() {
        return resumeContactsSiteType;
    }

    public IDictionary<TravelTime> getTravelTime() {
        return travelTime;
    }

    public IDictionary<SiteLang> getSiteLang() {
        return siteLang;
    }

    public IDictionary<VacancyType> getVacancyType() {
        return vacancyType;
    }

    private void loadSmallDictionaries() {
        try {
            String content = loader.loadContent(UrlConstants.DICTINARIES_URL);
            SmallDictionariesParser parse = new SmallDictionariesParser();
            SmallDictionariesContainer smallDictionaries = parse.parse(content);

            currency = new Dictionary<>(smallDictionaries.getCurrency(), Currency.NULL_CURRENCY);
            gender = new Dictionary<>(smallDictionaries.getGender(), Gender.NULL_GENDER);
            schedule = new Dictionary<>(smallDictionaries.getSchedule(), Schedule.NULL_SCHEDULE);
            educationLevel = new Dictionary<>(smallDictionaries.getEducationLevel(), EducationLevel.NULL_EDUCATION_LEVEL);
            employment = new Dictionary<>(smallDictionaries.getEmployment(), Employment.NULL_EMPLOYMENT);
            order = new Dictionary<>(smallDictionaries.getOrder(), Order.NULL_ORDER);
            vacancySearchFields = new Dictionary<>(smallDictionaries.getVacancySearchFields(), VacancySearchFields.NULL_VACANCY_SEARCH_FIELD);
            experience = new Dictionary<>(smallDictionaries.getExperience(), Experience.NULL_EXPERIENCE);
            employerType = new Dictionary<>(smallDictionaries.getEmployerType(), EmployerType.NULL_EMPLOYER_TYPE);
            label = new Dictionary<>(smallDictionaries.getLabel(), Label.NULL_LABEL);
            businessTripReadiness = new Dictionary<>(smallDictionaries.getBusinessTripReadiness(), BusinessTripReadiness.NULL_BUSINESS_TRIP_READINESS);
            languageLevel = new Dictionary<>(smallDictionaries.getLanguageLevel(), LanguageLevel.NULL_LANGUAGE_LEVEL);
            preferredContactType = new Dictionary<>(smallDictionaries.getPreferredContactType(), PreferredContactType.NULL_PREFERRED_CONTACT_TYPE);
            relocationType = new Dictionary<>(smallDictionaries.getRelocationType(), RelocationType.NULL_RELOCATION_TYPE);
            resumeAccessType = new Dictionary<>(smallDictionaries.getResumeAccessType(), ResumeAccessType.NULL_RESUME_ACCESS_TYPE);
            resumeContactsSiteType = new Dictionary<>(smallDictionaries.getResumeContactsSiteType(), ResumeContactsSiteType.NULL_RESUME_CONTACTS_SITE_TYPE);
            travelTime = new Dictionary<>(smallDictionaries.getTravelTime(), TravelTime.NULL_TRAVEL_TIME);
            siteLang = new Dictionary<>(smallDictionaries.getSiteLang(), SiteLang.NULL_SITE_LANG);
            vacancyType = new Dictionary<>(smallDictionaries.getVacancyType(), VacancyType.NULL_VACANCY_TYPE);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

}
