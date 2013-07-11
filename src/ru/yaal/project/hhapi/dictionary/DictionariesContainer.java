package ru.yaal.project.hhapi.dictionary;

import java.util.List;

import ru.yaal.project.hhapi.dictionary.entry.entries.BusinessTripReadiness;
import ru.yaal.project.hhapi.dictionary.entry.entries.ResumeContactsSiteType;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancyType;
import ru.yaal.project.hhapi.dictionary.entry.entries.Currency;
import ru.yaal.project.hhapi.dictionary.entry.entries.EducationLevel;
import ru.yaal.project.hhapi.dictionary.entry.entries.Employment;
import ru.yaal.project.hhapi.dictionary.entry.entries.Experience;
import ru.yaal.project.hhapi.dictionary.entry.entries.Gender;
import ru.yaal.project.hhapi.dictionary.entry.entries.LanguageLevel;
import ru.yaal.project.hhapi.dictionary.entry.entries.PreferredContactType;
import ru.yaal.project.hhapi.dictionary.entry.entries.RelocationType;
import ru.yaal.project.hhapi.dictionary.entry.entries.ResumeAccessType;
import ru.yaal.project.hhapi.dictionary.entry.entries.Schedule;
import ru.yaal.project.hhapi.dictionary.entry.entries.SiteLang;
import ru.yaal.project.hhapi.dictionary.entry.entries.TravelTime;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancyLabel;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchFields;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchOrder;
import lombok.Data;

@Data
public class DictionariesContainer {
	private List<ResumeContactsSiteType> resume_contacts_site_type;
	private List<Schedule> schedule;
	private List<BusinessTripReadiness> business_trip_readiness;
	private List<VacancySearchFields> vacancy_search_fields;
	private List<Currency> currency;
	private List<TravelTime> travel_time;
	private List<EducationLevel> education_level;
	private List<RelocationType> relocation_type;
	private List<ResumeAccessType> resume_access_type;
	private List<Employment> employment;
	private List<VacancyLabel> vacancy_label;
	private List<Gender> gender;
	private List<LanguageLevel> language_level;
	private List<Experience> experience;
	private List<PreferredContactType> preferred_contact_type;
	private List<VacancySearchOrder> vacancy_search_order;
	private List<VacancyType> vacancy_type;
	private List<SiteLang> site_lang;
}
