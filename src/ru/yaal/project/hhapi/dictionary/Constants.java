package ru.yaal.project.hhapi.dictionary;

import ru.yaal.project.hhapi.dictionary.entry.entries.small.SmallDictionariesInitializer;

/**
 * ��������� ��� ������� � "�����" ������������.
 *
 * @see ru.yaal.project.hhapi.dictionary.entry.entries.proffield.ProfField#PROF_FIELDS ���������� ���������������� ��������
 * @see ru.yaal.project.hhapi.dictionary.entry.entries.area.Area#AREAS ���������� �������
 * @see ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroCity#CITIES ���������� ������� � �����
 * @see ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroLine ����������� ����� �����
 * @see ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroStation#STATIONS ���������� ������� �����
 */
@SuppressWarnings("unused")
public interface Constants {
    /**
     * ���� �����.
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.SiteLang
     */
    public static interface SiteLang {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.SiteLang>
                SITE_LANGS = SmallDictionariesInitializer.getInstance().getSiteLang();
        /**
         * ��-������.
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
     * ��� (������).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.Gender
     */
    public static interface Gender {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.Gender>
                GENDERS = SmallDictionariesInitializer.getInstance().getGender();
        /**
         * �� �����.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Gender
                UNKNOWN = GENDERS.getById("unknown");
        /**
         * �������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Gender
                MALE = GENDERS.getById("male");
        /**
         * �������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Gender
                FEMALE = GENDERS.getById("female");
    }

    /**
     * ���������� � ������������� (������).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.BusinessTripReadiness
     */
    public static interface BusinessTripReadiness {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.BusinessTripReadiness>
                READINESS = SmallDictionariesInitializer.getInstance().getBusinessTripReadiness();
        /**
         * ����� � �������������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.BusinessTripReadiness
                READY = READINESS.getById("ready");
        /**
         * ����� � ������ �������������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.BusinessTripReadiness
                SOMETIMES = READINESS.getById("sometimes");
        /**
         * �� ����� � �������������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.BusinessTripReadiness
                NEVER = READINESS.getById("never");
    }

    /**
     * ������.
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency
     */
    public static interface Currency {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency>
                CURRENCIES = SmallDictionariesInitializer.getInstance().getCurrency();
        /**
         * �����.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency
                RUR = CURRENCIES.getById("RUR");
        /**
         * �������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency
                USD = CURRENCIES.getById("USD");
        /**
         * ����.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency
                EUR = CURRENCIES.getById("EUR");
        /**
         * ������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency
                AZN = CURRENCIES.getById("AZN");
        /**
         * ����������� �����.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency
                BYR = CURRENCIES.getById("BYR");
        /**
         * �����.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency
                KZT = CURRENCIES.getById("KZT");
        /**
         * ������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency
                UAH = CURRENCIES.getById("UAH");
    }

    /**
     * ����������� (������).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
     */
    public static interface EducationLevel {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel>
                EDUCATION_LEVELS = SmallDictionariesInitializer.getInstance().getEducationLevel();
        /**
         * ������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
                HIGHER = EDUCATION_LEVELS.getById("higher");
        /**
         * ��������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
                BACHELOR = EDUCATION_LEVELS.getById("bachelor");
        /**
         * �������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
                MASTER = EDUCATION_LEVELS.getById("master");
        /**
         * �������� ����.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
                CANDIDATE = EDUCATION_LEVELS.getById("candidate");
        /**
         * ������ ����.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
                DOCTOR = EDUCATION_LEVELS.getById("doctor");
        /**
         * ������������ ������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
                UNFINISHED_HIGHER = EDUCATION_LEVELS.getById("unfinished_higher");
        /**
         * �������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
                SECONDARY = EDUCATION_LEVELS.getById("secondary");
        /**
         * ������� �����������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.EducationLevel
                SPECIAL_SECONDARY = EDUCATION_LEVELS.getById("special_secondary");
    }

    /**
     * ��� ��������� (��������).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.Employment
     */
    public static interface Employment {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.Employment>
                EMPLOYMENTS = SmallDictionariesInitializer.getInstance().getEmployment();
        /**
         * ������ ���������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Employment
                FULL = EMPLOYMENTS.getById("full");
        /**
         * ��������� ���������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Employment
                PART = EMPLOYMENTS.getById("part");
        /**
         * ��������� ������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Employment
                PROJECT = EMPLOYMENTS.getById("project");
        /**
         * ������������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Employment
                VOLUNTEER = EMPLOYMENTS.getById("volunteer");
        /**
         * ����������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Employment
                PROBATION = EMPLOYMENTS.getById("probation");
    }

    /**
     * ���� ������ (��������).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.Experience
     */
    public static interface Experience {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.Experience>
                EXPERIENCES = SmallDictionariesInitializer.getInstance().getExperience();
        /**
         * ��� �����.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Experience
                NO_EXPERIENCE = EXPERIENCES.getById("noExperience");
        /**
         * �� 1 ���� �� 3 ���.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Experience
                BETWEEN_1_AND_3 = EXPERIENCES.getById("between1And3");
        /**
         * �� 3 �� 6 ���.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Experience
                BETWEEN_3_AND_6 = EXPERIENCES.getById("between3And6");
        /**
         * ����� 6 ���.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Experience
                MORE_THAN_6 = EXPERIENCES.getById("moreThan6");
    }

    /**
     * ������ ������.
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.Schedule
     */
    public static interface Schedule {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.Schedule>
                SCHEDULES = SmallDictionariesInitializer.getInstance().getSchedule();
        /**
         * ������ ����.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Schedule
                FULL_DAY = SCHEDULES.getById("fullDay");
        /**
         * ������� ������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Schedule
                SHIFT = SCHEDULES.getById("shift");
        /**
         * ������ ������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Schedule
                FLEXIBLE = SCHEDULES.getById("flexible");
        /**
         * ��������� ������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Schedule
                REMOTE = SCHEDULES.getById("remote");
    }

    /**
     * ����� ��������.
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.Label
     */
    public static interface Label {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.Label>
                LABELS = SmallDictionariesInitializer.getInstance().getLabel();
        /**
         * ������ � �������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Label
                WITH_ADDRESS = LABELS.getById("with_address");
        /**
         * ������ ��������� ��� ����� � �������������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Label
                ACCEPT_HANDICAPPED = LABELS.getById("accept_handicapped");
        /**
         * ��� �������� ��������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Label
                NOT_FROM_AGENCY = LABELS.getById("not_from_agency");

    }

    /**
     * ������� �������� ������ (������).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.LanguageLevel
     */
    public static interface LanguageLevel {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.LanguageLevel>
                LANGUAGE_LEVELS = SmallDictionariesInitializer.getInstance().getLanguageLevel();
        /**
         * ������� ������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.LanguageLevel
                BASIC = LANGUAGE_LEVELS.getById("basic");
        /**
         * ����� ���������������� ����������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.LanguageLevel
                CAN_READ = LANGUAGE_LEVELS.getById("can_read");
        /**
         * ���� ��������� ��������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.LanguageLevel
                CAN_PASS_INTERVIEW = LANGUAGE_LEVELS.getById("can_pass_interview");
        /**
         * �������� ������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.LanguageLevel
                FLUENT = LANGUAGE_LEVELS.getById("fluent");
        /**
         * ������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.LanguageLevel
                NATIVE = LANGUAGE_LEVELS.getById("native");
    }

    /**
     * ��� ��������.
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancyType
     */
    public static interface VacancyType {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancyType>
                VACANCY_TYPES = SmallDictionariesInitializer.getInstance().getVacancyType();
        /**
         * ��������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancyType
                OPEN = VACANCY_TYPES.getById("open");
        /**
         * ��������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancyType
                CLOSED = VACANCY_TYPES.getById("closed");
        /**
         * ���������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancyType
                ANONYMOUS = VACANCY_TYPES.getById("anonymous");
        /**
         * � ������ ��������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancyType
                DIRECT = VACANCY_TYPES.getById("direct");
    }

    /**
     * ������� ������.
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancySearchFields
     */
    public static interface VacancySearchFields {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancySearchFields>
                VACANCY_SEARCH_FIELDS = SmallDictionariesInitializer.getInstance().getVacancySearchFields();
        /**
         * � �������� ��������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancySearchFields
                VACANCY_NAME = VACANCY_SEARCH_FIELDS.getById("name");
        /**
         * � �������� ��������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancySearchFields
                COMPANY_NAME = VACANCY_SEARCH_FIELDS.getById("company_name");
        /**
         * � �������� ��������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.VacancySearchFields
                DESCRIPTION = VACANCY_SEARCH_FIELDS.getById("description");
    }

    /**
     * ��� ������������.
     */
    public static interface EmployerType {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.employer.EmployerType>
                EMPLOYER_TYPES = SmallDictionariesInitializer.getInstance().getEmployerType();
        /**
         * ������ ������������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.employer.EmployerType
                COMPANY = EMPLOYER_TYPES.getById("company");
        /**
         * �������� ���������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.employer.EmployerType
                AGENCY = EMPLOYER_TYPES.getById("agency");
        /**
         * ������� ���������� �� ������� ���������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.employer.EmployerType
                PRIVATE_RECRUITER = EMPLOYER_TYPES.getById("private_recruiter");
    }

    /**
     * ����� � ���� (������).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.TravelTime
     */
    public static interface TravelTime {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.TravelTime>
                TRAVEL_TIMES = SmallDictionariesInitializer.getInstance().getTravelTime();
        /**
         * �� ����� ��������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.TravelTime
                ANY = TRAVEL_TIMES.getById("any");
        /**
         * �� ����� ����.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.TravelTime
                LESS_THAN_HOUR = TRAVEL_TIMES.getById("less_than_hour");
        /**
         * �� ����� �������� �����.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.TravelTime
                FROM_HOUR_TO_ONE_AND_HALF = TRAVEL_TIMES.getById("from_hour_to_one_and_half");
    }

    /**
     * ���������� � �������� (������).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.RelocationType
     */
    public static interface RelocationType {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.RelocationType>
                RELOCATION_TYPES = SmallDictionariesInitializer.getInstance().getRelocationType();
        /**
         * �� ����� � ��������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.RelocationType
                NO_RELOCATION = RELOCATION_TYPES.getById("no_relocation");
        /**
         * ����� � ��������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.RelocationType
                POSSIBLE = RELOCATION_TYPES.getById("relocation_possible");
        /**
         * ���� ���������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.RelocationType
                DESIRABLE = RELOCATION_TYPES.getById("relocation_desirable");
    }

    /**
     * ���������� ������ ��������.
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.Order
     */
    public static interface Order {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.Order>
                ORDERS = SmallDictionariesInitializer.getInstance().getOrder();
        /**
         * �� ����.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Order
                PUBLICATION_TIME = ORDERS.getById("publication_time");
        /**
         * �� �������� ��������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Order
                SALARY_DESC = ORDERS.getById("salary_desc");
        /**
         * �� ����������� ��������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Order
                SALARY_ASC = ORDERS.getById("salary_asc");
        /**
         * �� ������������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.Order
                RELEVANCE = ORDERS.getById("relevance");
    }

    /**
     * �������� ������ ����� (������).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.PreferredContactType
     */
    public static interface PreferredContactType {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.PreferredContactType>
                PREFERRED_CONTACT_TYPES = SmallDictionariesInitializer.getInstance().getPreferredContactType();
        /**
         * �������� �������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.PreferredContactType
                HOME = PREFERRED_CONTACT_TYPES.getById("home");
        /**
         * ������� �������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.PreferredContactType
                WORK = PREFERRED_CONTACT_TYPES.getById("work");
        /**
         * ��������� �������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.PreferredContactType
                CELL = PREFERRED_CONTACT_TYPES.getById("cell");
        /**
         * ��. �����.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.PreferredContactType
                EMAIL = PREFERRED_CONTACT_TYPES.getById("email");

    }

    /**
     * ��� ����� � ���� ���������� (������).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeContactsSiteType
     */
    public static interface ResumeContactsSiteType {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeContactsSiteType>
                RESUME_CONTACTS_SITE_TYPES = SmallDictionariesInitializer.getInstance().getResumeContactsSiteType();
        /**
         * ������ ����.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeContactsSiteType
                PERSONAL = RESUME_CONTACTS_SITE_TYPES.getById("personal");
        /**
         * ��� ����.
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
     * ������� ������� � ������ (������).
     *
     * @see ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeAccessType
     */
    public static interface ResumeAccessType {
        public static final IDictionary<ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeAccessType>
                RESUME_ACCESS_TYPES = SmallDictionariesInitializer.getInstance().getResumeAccessType();
        /**
         * �������� (������ �� ����� ������).
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeAccessType
                NO_ONE = RESUME_ACCESS_TYPES.getById("no_one");
        /**
         * ������ ����� ������ ��������� ���������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeAccessType
                WHITE_LIST = RESUME_ACCESS_TYPES.getById("whitelist");
        /**
         * ��� ��������, ����� ��������� (������ � ���������� ���������).
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeAccessType
                BLACK_LIST = RESUME_ACCESS_TYPES.getById("blacklist");
        /**
         * ����� ������ ������� hh.ru.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeAccessType
                CLIENTS = RESUME_ACCESS_TYPES.getById("clients");
        /**
         * ����� ����� ���������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeAccessType
                EVERYONE = RESUME_ACCESS_TYPES.getById("everyone");
        /**
         * ������ ����� ������ �� ������ ������.
         */
        public static final ru.yaal.project.hhapi.dictionary.entry.entries.small.ResumeAccessType
                DIRECT = RESUME_ACCESS_TYPES.getById("direct");
    }

    /**
     * ������ � ��������� ���������.
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
