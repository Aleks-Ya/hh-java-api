package ru.yaal.project.hhapi;

public class HhConstants {
	private static final String yablokovAccessToken = "PMM470P5R97MC6NEV538GB882TLJA5FPM9FPOTQ5MEDG4K1BSO0V3GAG37LP8K1J";
	private static final String refreshToken = "GK7QG513787K4D8I4GFPR5DMUAEHHPCIJ323CTB9PHNUM931TGFD5MCI4CH0IL0K";
	
	public static final String BASE_API_URL = "https://api.hh.ru";
	public static final String ME_URL = BASE_API_URL + "/me";
	public static final String VACANCIES_URL = BASE_API_URL + "/vacancies";
	public static final String VACANCY_URL = BASE_API_URL + "/vacancies/%s";
	public static final String DICTINARIES_URL = BASE_API_URL + "/dictionaries";
	public static final String SPECIALIZATIONS_URL = BASE_API_URL + "/specializations";
	public static final String AREAS_URL = BASE_API_URL + "/areas";
	public static final String AREA_URL = BASE_API_URL + "/areas/%s";
	public static final HhToken YABLOKOV_TOKEN = new HhToken(yablokovAccessToken, refreshToken); 
			


	}
