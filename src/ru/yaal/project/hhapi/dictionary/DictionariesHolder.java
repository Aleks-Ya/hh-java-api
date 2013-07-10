package ru.yaal.project.hhapi.dictionary;

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
import ru.yaal.project.hhapi.dictionary.entry.entries.SiteType;
import ru.yaal.project.hhapi.dictionary.entry.entries.TravelTime;
import ru.yaal.project.hhapi.dictionary.entry.entries.VacancyLabel;
import ru.yaal.project.hhapi.dictionary.entry.entries.VacancySearchFields;
import ru.yaal.project.hhapi.dictionary.entry.entries.VacancySearchOrder;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;

public class DictionariesHolder {
	private static Dictionary<Currency> currencyCashe;
	private static Dictionary<EducationLevel> educationLevelCashe;
	private static Dictionary<Employment> employmentCashe;
	private static Dictionary<Experience> experienceCashe;
	private static Dictionary<Gender> genderCashe;
	private static Dictionary<LanguageLevel> languageLevelCashe;
	private static Dictionary<PreferredContactType> preferredContactTypeCashe;
	private static Dictionary<RelocationType> relocationTypeCashe;
	private static Dictionary<ResumeAccessType> resumeAccessTypeCashe;
	private static Dictionary<Schedule> scheduleCashe;
	private static Dictionary<SiteLang> siteLangCashe;
	private static Dictionary<SiteType> siteTypeCashe;
	private static Dictionary<TravelTime> travelTimeCashe;
	private static Dictionary<VacancyLabel> vacancyLabelCashe;
	private static Dictionary<VacancySearchFields> vacancySearchFieldsCashe;
	private static Dictionary<VacancySearchOrder> vacancySearchOrderCashe;

	private static Dictionary<Area> areaCashe;

	public static Dictionary<Currency> getCurrencyDict()
			throws DictionaryException {
		if (currencyCashe == null) {
			loadDictionaries();
		}
		return currencyCashe;
	}

	public static Dictionary<EducationLevel> getEducationLevelDict()
			throws DictionaryException {
		if (educationLevelCashe == null) {
			loadDictionaries();
		}
		return educationLevelCashe;
	}

	public static Dictionary<Area> getAreaDict() throws DictionaryException {
		if (areaCashe == null) {
			loadAreas();
		}
		return areaCashe;
	}

	private static void loadAreas() throws DictionaryException {
//		try {
//			IContentLoader loader = new ContentLoader();
//			String content = loader.loadContent(HhConstants.AREAS_URL);
//			IParser<Dictionary<Area>> parser = new AreasParser();
//			areaCashe = parser.parse(content);
//		} catch (LoadException | ParseException e) {
//			throw new DictionaryException(e);
//		}
	}
	
	private static void loadDictionaries() throws DictionaryException {
//		try {
//			IContentLoader loader = new ContentLoader();
//			String content = loader.loadContent(HhConstants.DICTINARIES_URL);
//			SmallDictionariesParser parser = new SmallDictionariesParser();
//			DictionariesContainer dictionries = parser.parse(content);
//			currencyCashe = new Dictionary<Currency>(dictionries.getCurrency());
//			educationLevelCashe = new Dictionary<EducationLevel>(
//					dictionries.getEducation_level());
//
//		} catch (LoadException | ParseException e) {
//			throw new DictionaryException(e);
//		}		
	}

}
