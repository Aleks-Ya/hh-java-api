package ru.yaal.project.hhapi.dictionary;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.AreaDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.currency.Currency;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCityDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalFieldDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.*;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.Order;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchFields;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.parser.*;

public class Dictionaries2 {
    private static final Logger LOG = LoggerFactory.getLogger(Dictionaries2.class);
    private static Dictionaries2 dictionary;
    private IContentLoader loader = ContentLoaderFactory.newInstanceLongTermCache();
    @Getter
    private AreaDictionary areas;
    @Getter
    private MetroCityDictionary metroCities;
    @Getter
    private ProfessionalFieldDictionary professionalFields;
    @Getter
    private IDictionary<Currency> currency;
    @Getter
    private IDictionary<Gender> gender;
    @Getter
    private IDictionary<Schedule> schedule;
    @Getter
    private IDictionary<EducationLevel> educationLevel;
    @Getter
    private IDictionary<Employment> employment;
    @Getter
    private IDictionary<Order> order;
    @Getter
    private IDictionary<VacancySearchFields> vacancySearchFields;
    @Getter
    private IDictionary<Experience> experience;

    private Dictionaries2() {
        LOG.debug("Создаю инстанс Dictionaries2");
        loadSmallDictionaries();
        loadAreas();
        loadMetro();
        loadProfessionalFields();
    }

    public static Dictionaries2 getInstance() {
        if (dictionary == null) dictionary = new Dictionaries2();
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
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

}
