package ru.yaal.project.hhapi.dictionary;

import ru.yaal.project.hhapi.dictionary.entry.entries.small.SmallDictionariesInitializer;

/**
 * Константы для доступа к "малым" справочникам.
 *
 * @see ru.yaal.project.hhapi.dictionary.entry.entries.proffield.ProfField#PROF_FIELDS Справочник профессиональных областей
 * @see ru.yaal.project.hhapi.dictionary.entry.entries.area.Area#AREAS Справочник районов
 * @see ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCity#CITIES Справочник городов с метро
 * @see ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroLine Справочники веток метро
 * @see ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroStation#STATIONS Справочник станций метро
 */
@SuppressWarnings("unused")
public interface Constants {
    /**
     * Язык сайта.
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.SiteLang
     */
    public static interface SiteLang {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.SiteLang>
                SITE_LANGS = SmallDictionariesInitializer.getInstance().getSiteLang();
        /**
         * По-русски.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.SiteLang
                RU = SITE_LANGS.getById("ru");
        /**
         * In English.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.SiteLang
                EN = SITE_LANGS.getById("en");
    }

    /**
     * Пол (резюме).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.Gender
     */
    public static interface Gender {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.Gender>
                GENDERS = SmallDictionariesInitializer.getInstance().getGender();
        /**
         * Не скажу.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Gender
                UNKNOWN = GENDERS.getById("unknown");
        /**
         * Мужской.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Gender
                MALE = GENDERS.getById("male");
        /**
         * Женский.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Gender
                FEMALE = GENDERS.getById("female");
    }

    /**
     * Готовность к командировкам (резюме).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.BusinessTripReadiness
     */
    public static interface BusinessTripReadiness {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.BusinessTripReadiness>
                READINESS = SmallDictionariesInitializer.getInstance().getBusinessTripReadiness();
        /**
         * Готов к командировкам.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.BusinessTripReadiness
                READY = READINESS.getById("ready");
        /**
         * Готов к редким командировкам.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.BusinessTripReadiness
                SOMETIMES = READINESS.getById("sometimes");
        /**
         * Не готов к командировкам.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.BusinessTripReadiness
                NEVER = READINESS.getById("never");
    }

    /**
     * Валюта.
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency
     */
    public static interface Currency {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency>
                CURRENCIES = SmallDictionariesInitializer.getInstance().getCurrency();
        /**
         * Рубли.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency
                RUR = CURRENCIES.getById("RUR");
        /**
         * Доллары.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency
                USD = CURRENCIES.getById("USD");
        /**
         * Евро.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency
                EUR = CURRENCIES.getById("EUR");
        /**
         * Манаты.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency
                AZN = CURRENCIES.getById("AZN");
        /**
         * Белорусские рубли.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency
                BYR = CURRENCIES.getById("BYR");
        /**
         * Тенге.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency
                KZT = CURRENCIES.getById("KZT");
        /**
         * Гривны.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency
                UAH = CURRENCIES.getById("UAH");
    }

    /**
     * Образование (резюме).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
     */
    public static interface EducationLevel {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel>
                EDUCATION_LEVELS = SmallDictionariesInitializer.getInstance().getEducationLevel();
        /**
         * Высшее.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
                HIGHER = EDUCATION_LEVELS.getById("higher");
        /**
         * Бакалавр.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
                BACHELOR = EDUCATION_LEVELS.getById("bachelor");
        /**
         * Магистр.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
                MASTER = EDUCATION_LEVELS.getById("master");
        /**
         * Кандидат наук.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
                CANDIDATE = EDUCATION_LEVELS.getById("candidate");
        /**
         * Доктор наук.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
                DOCTOR = EDUCATION_LEVELS.getById("doctor");
        /**
         * Неоконченное высшее.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
                UNFINISHED_HIGHER = EDUCATION_LEVELS.getById("unfinished_higher");
        /**
         * Среднее.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
                SECONDARY = EDUCATION_LEVELS.getById("secondary");
        /**
         * Среднее специальное.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
                SPECIAL_SECONDARY = EDUCATION_LEVELS.getById("special_secondary");
    }

    /**
     * Тип занятости (вакансия).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.Employment
     */
    public static interface Employment {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.Employment>
                EMPLOYMENTS = SmallDictionariesInitializer.getInstance().getEmployment();
        /**
         * Полная занятость.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Employment
                FULL = EMPLOYMENTS.getById("full");
        /**
         * Частичная занятость.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Employment
                PART = EMPLOYMENTS.getById("part");
        /**
         * Проектная работа.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Employment
                PROJECT = EMPLOYMENTS.getById("project");
        /**
         * Волонтерство.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Employment
                VOLUNTEER = EMPLOYMENTS.getById("volunteer");
        /**
         * Стажировка.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Employment
                PROBATION = EMPLOYMENTS.getById("probation");
    }

    /**
     * Опыт работы (вакансия).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.Experience
     */
    public static interface Experience {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.Experience>
                EXPERIENCES = SmallDictionariesInitializer.getInstance().getExperience();
        /**
         * Нет опыта.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Experience
                NO_EXPERIENCE = EXPERIENCES.getById("noExperience");
        /**
         * От 1 года до 3 лет.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Experience
                BETWEEN_1_AND_3 = EXPERIENCES.getById("between1And3");
        /**
         * От 3 до 6 лет.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Experience
                BETWEEN_3_AND_6 = EXPERIENCES.getById("between3And6");
        /**
         * Более 6 лет.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Experience
                MORE_THAN_6 = EXPERIENCES.getById("moreThan6");
    }

    /**
     * График работы.
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.Schedule
     */
    public static interface Schedule {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.Schedule>
                SCHEDULES = SmallDictionariesInitializer.getInstance().getSchedule();
        /**
         * Полный день.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Schedule
                FULL_DAY = SCHEDULES.getById("fullDay");
        /**
         * Сменный график.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Schedule
                SHIFT = SCHEDULES.getById("shift");
        /**
         * Гибкий график.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Schedule
                FLEXIBLE = SCHEDULES.getById("flexible");
        /**
         * Удаленная работа.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Schedule
                REMOTE = SCHEDULES.getById("remote");
    }

    /**
     * Метки вакансии.
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.Label
     */
    public static interface Label {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.Label>
                LABELS = SmallDictionariesInitializer.getInstance().getLabel();
        /**
         * Только с адресом.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Label
                WITH_ADDRESS = LABELS.getById("with_address");
        /**
         * Только доступные для людей с инвалидностью.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Label
                ACCEPT_HANDICAPPED = LABELS.getById("accept_handicapped");
        /**
         * Без вакансий агентств.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Label
                NOT_FROM_AGENCY = LABELS.getById("not_from_agency");

    }

    /**
     * Уровень владения языком (резюме).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.LanguageLevel
     */
    public static interface LanguageLevel {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.LanguageLevel>
                LANGUAGE_LEVELS = SmallDictionariesInitializer.getInstance().getLanguageLevel();
        /**
         * Базовые знания.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.LanguageLevel
                BASIC = LANGUAGE_LEVELS.getById("basic");
        /**
         * Читаю профессиональную литературу.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.LanguageLevel
                CAN_READ = LANGUAGE_LEVELS.getById("can_read");
        /**
         * Могу проходить интервью.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.LanguageLevel
                CAN_PASS_INTERVIEW = LANGUAGE_LEVELS.getById("can_pass_interview");
        /**
         * Свободно владею.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.LanguageLevel
                FLUENT = LANGUAGE_LEVELS.getById("fluent");
        /**
         * Родной.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.LanguageLevel
                NATIVE = LANGUAGE_LEVELS.getById("native");
    }

    /**
     * Тип вакансии.
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancyType
     */
    public static interface VacancyType {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancyType>
                VACANCY_TYPES = SmallDictionariesInitializer.getInstance().getVacancyType();
        /**
         * Открытая.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancyType
                OPEN = VACANCY_TYPES.getById("open");
        /**
         * Закрытая.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancyType
                CLOSED = VACANCY_TYPES.getById("closed");
        /**
         * Анонимная.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancyType
                ANONYMOUS = VACANCY_TYPES.getById("anonymous");
        /**
         * С прямым откликом.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancyType
                DIRECT = VACANCY_TYPES.getById("direct");
    }

    /**
     * Область поиска.
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancySearchFields
     */
    public static interface VacancySearchFields {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancySearchFields>
                VACANCY_SEARCH_FIELDS = SmallDictionariesInitializer.getInstance().getVacancySearchFields();
        /**
         * В названии вакансии.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancySearchFields
                VACANCY_NAME = VACANCY_SEARCH_FIELDS.getById("name");
        /**
         * В названии компании.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancySearchFields
                COMPANY_NAME = VACANCY_SEARCH_FIELDS.getById("company_name");
        /**
         * В описании вакансии.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancySearchFields
                DESCRIPTION = VACANCY_SEARCH_FIELDS.getById("description");
    }

    /**
     * Тип работодателя.
     */
    public static interface EmployerType {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.employer.EmployerType>
                EMPLOYER_TYPES = SmallDictionariesInitializer.getInstance().getEmployerType();
        /**
         * Прямой работодатель.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.employer.EmployerType
                COMPANY = EMPLOYER_TYPES.getById("company");
        /**
         * Кадровое агентство.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.employer.EmployerType
                AGENCY = EMPLOYER_TYPES.getById("agency");
        /**
         * Частный специалист по подбору персонала.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.employer.EmployerType
                PRIVATE_RECRUITER = EMPLOYER_TYPES.getById("private_recruiter");
    }

    /**
     * Время в пути (резюме).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.TravelTime
     */
    public static interface TravelTime {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.TravelTime>
                TRAVEL_TIMES = SmallDictionariesInitializer.getInstance().getTravelTime();
        /**
         * Не имеет значения.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.TravelTime
                ANY = TRAVEL_TIMES.getById("any");
        /**
         * Не более часа.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.TravelTime
                LESS_THAN_HOUR = TRAVEL_TIMES.getById("less_than_hour");
        /**
         * Не более полутора часов.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.TravelTime
                FROM_HOUR_TO_ONE_AND_HALF = TRAVEL_TIMES.getById("from_hour_to_one_and_half");
    }

    /**
     * Готовность к переезду (резюме).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.RelocationType
     */
    public static interface RelocationType {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.RelocationType>
                RELOCATION_TYPES = SmallDictionariesInitializer.getInstance().getRelocationType();
        /**
         * Не готов к переезду.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.RelocationType
                NO_RELOCATION = RELOCATION_TYPES.getById("no_relocation");
        /**
         * Готов к переезду.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.RelocationType
                POSSIBLE = RELOCATION_TYPES.getById("relocation_possible");
        /**
         * Хочу переехать.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.RelocationType
                DESIRABLE = RELOCATION_TYPES.getById("relocation_desirable");
    }

    /**
     * Сортировка списка вакансий.
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.Order
     */
    public static interface Order {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.Order>
                ORDERS = SmallDictionariesInitializer.getInstance().getOrder();
        /**
         * По дате.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Order
                PUBLICATION_TIME = ORDERS.getById("publication_time");
        /**
         * По убыванию зарплаты.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Order
                SALARY_DESC = ORDERS.getById("salary_desc");
        /**
         * По возрастанию зарплаты.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Order
                SALARY_ASC = ORDERS.getById("salary_asc");
        /**
         * По соответствию.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Order
                RELEVANCE = ORDERS.getById("relevance");
    }

    /**
     * Желаемый способ связи (резюме).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.PreferredContactType
     */
    public static interface PreferredContactType {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.PreferredContactType>
                PREFERRED_CONTACT_TYPES = SmallDictionariesInitializer.getInstance().getPreferredContactType();
        /**
         * Домашний телефон.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.PreferredContactType
                HOME = PREFERRED_CONTACT_TYPES.getById("home");
        /**
         * Рабочий телефон.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.PreferredContactType
                WORK = PREFERRED_CONTACT_TYPES.getById("work");
        /**
         * Мобильный телефон.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.PreferredContactType
                CELL = PREFERRED_CONTACT_TYPES.getById("cell");
        /**
         * Эл. почта.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.PreferredContactType
                EMAIL = PREFERRED_CONTACT_TYPES.getById("email");

    }

    /**
     * Тип сайта в поле «контакты» (резюме).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeContactsSiteType
     */
    public static interface ResumeContactsSiteType {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeContactsSiteType>
                RESUME_CONTACTS_SITE_TYPES = SmallDictionariesInitializer.getInstance().getResumeContactsSiteType();
        /**
         * Другой сайт.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeContactsSiteType
                PERSONAL = RESUME_CONTACTS_SITE_TYPES.getById("personal");
        /**
         * Мой круг.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeContactsSiteType
                MOI_KRUG = RESUME_CONTACTS_SITE_TYPES.getById("moi_krug");
        /**
         * LiveJournal.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeContactsSiteType
                LIVEJOURNAL = RESUME_CONTACTS_SITE_TYPES.getById("livejournal");
        /**
         * LinkedIn.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeContactsSiteType
                LINKEDIN = RESUME_CONTACTS_SITE_TYPES.getById("linkedin");
        /**
         * Free-lance.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeContactsSiteType
                FREELANCE = RESUME_CONTACTS_SITE_TYPES.getById("freelance");
        /**
         * Facebook.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeContactsSiteType
                FACEBOOK = RESUME_CONTACTS_SITE_TYPES.getById("facebook");
        /**
         * Skype.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeContactsSiteType
                SKYPE = RESUME_CONTACTS_SITE_TYPES.getById("skype");
        /**
         * ICQ.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeContactsSiteType
                ICQ = RESUME_CONTACTS_SITE_TYPES.getById("icq");
        /**
         * Jabber.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeContactsSiteType
                JABBER = RESUME_CONTACTS_SITE_TYPES.getById("jabber");

    }

    /**
     * Уровень доступа к резюме (резюме).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeAccessType
     */
    public static interface ResumeAccessType {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeAccessType>
                RESUME_ACCESS_TYPES = SmallDictionariesInitializer.getInstance().getResumeAccessType();
        /**
         * Закрытое (резюме не видно никому).
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeAccessType
                NO_ONE = RESUME_ACCESS_TYPES.getById("no_one");
        /**
         * Резюме видно только выбранным компаниям.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeAccessType
                WHITE_LIST = RESUME_ACCESS_TYPES.getById("whitelist");
        /**
         * Все компании, кроме выбранных (список в настройках видимости).
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeAccessType
                BLACK_LIST = RESUME_ACCESS_TYPES.getById("blacklist");
        /**
         * Видят только клиенты hh.ru.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeAccessType
                CLIENTS = RESUME_ACCESS_TYPES.getById("clients");
        /**
         * Видно всему интернету.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeAccessType
                EVERYONE = RESUME_ACCESS_TYPES.getById("everyone");
        /**
         * Резюме видно только по прямой ссылке.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeAccessType
                DIRECT = RESUME_ACCESS_TYPES.getById("direct");
    }

    /**
     * Только с указанной зарплатой.
     *
     * @see ru.yaal.project.hhapi.search.parameter.OnlyWithSalary
     */
    public static interface OnlyWithSalary {
        public static final ru.yaal.project.hhapi.search.parameter.OnlyWithSalary
                ON = new ru.yaal.project.hhapi.search.parameter.OnlyWithSalary(true);
        public static final ru.yaal.project.hhapi.search.parameter.OnlyWithSalary
                OFF = new ru.yaal.project.hhapi.search.parameter.OnlyWithSalary(false);
    }
}
