package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import lombok.Getter;
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
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<Currency> currency;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<Gender> gender;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<Schedule> schedule;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<EducationLevel> educationLevel;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<Employment> employment;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<Order> order;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<VacancySearchFields> vacancySearchFields;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<Experience> experience;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<EmployerType> employerType;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<VacancyLabel> vacancyLabel;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<BusinessTripReadiness> businessTripReadiness;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<LanguageLevel> languageLevel;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<PreferredContactType> preferredContactType;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<RelocationType> relocationType;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<ResumeAccessType> resumeAccessType;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<ResumeContactsSiteType> resumeContactsSiteType;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<TravelTime> travelTime;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<SiteLang> siteLang;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private IDictionary<VacancyType> vacancyType;

    private SmallDictionariesInitializer() {
        LOG.debug("Создаю инстанс SmallDictionariesInitializer");
        loadSmallDictionaries();
    }

    public static SmallDictionariesInitializer getInstance() {
        if (dictionary == null) {
            dictionary = new SmallDictionariesInitializer();
        }
        return dictionary;
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
            vacancyLabel = new Dictionary<>(smallDictionaries.getVacancyLabel(), VacancyLabel.NULL_VACANCY_LABEL);
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
