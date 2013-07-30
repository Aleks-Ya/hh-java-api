package ru.yaal.project.hhapi.dictionary;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.AreaDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.currency.Currency;
import ru.yaal.project.hhapi.dictionary.entry.entries.employer.EmployerType;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCityDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalFieldDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.*;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.Order;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchFields;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.parser.*;

public final class Dictionaries {
    private static final Logger LOG = LoggerFactory.getLogger(Dictionaries.class);
    private static Dictionaries dictionary;
    private IContentLoader loader = ContentLoaderFactory.newInstanceLongTermCache();
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private AreaDictionary areas;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private MetroCityDictionary metroCities;
    @Getter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private ProfessionalFieldDictionary professionalFields;
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

    private Dictionaries() {
        LOG.debug("Создаю инстанс Dictionaries");
        loadSmallDictionaries();
        loadAreas();
        loadMetro();
        loadProfessionalFields();
    }

    public static Dictionaries getInstance() {
        if (dictionary == null) {
            dictionary = new Dictionaries();
        }
        return dictionary;
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

    private void loadSmallDictionaries() {
        try {
            String content = loader.loadContent(UrlConstants.DICTINARIES_URL);
            SmallDictionariesParser parse = new SmallDictionariesParser();
            DictionariesContainer smallDictionaries = parse.parse(content);

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
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

}
