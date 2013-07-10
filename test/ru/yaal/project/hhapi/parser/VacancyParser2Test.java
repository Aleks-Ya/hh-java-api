package ru.yaal.project.hhapi.parser;

import org.junit.Test;

public class VacancyParser2Test {

	@Test
	public void test() {
		final String requestContent = "{\"description\": \"<p> В связи с расширением бизнеса Группа Компаний &quot;Алкон&quot; открывает конкурс на вакансию <strong>торговый представитель </strong><strong> </strong></p> <p> <strong>Обязанности:</strong></p> <ul> <li> поддержание и развитие клиентской базы (напитки)</li> <li> отслеживание дебиторской задолженности</li> <li> отчетность</li> <li> мерчандайзинг</li> </ul> <p> <strong>Требования:</strong></p> <ul> <li> мужчина/женщина, 21-45 лет</li> <li> прописка СПб или Лен.область</li> <li> наличие автомобиля обязательно</li> <li> опыт продаж</li> <li> коммуникабельность,инициативность</li> </ul> <p> <strong>Условия:</strong></p> <ul> <li> работа в крупной успешной компании</li> <li> оформление по ТК РФ</li> <li> график работы 5/2 с 09.00-18.00</li> <li> офис м.Рыбацкое</li> </ul>\", "
				+ "\"schedule\": {\"id\": \"fullDay\", \"name\": \"Полный день\"}, "
				+ "\"accept_handicapped\": false, "
				+ "\"experience\": {\"id\": \"between1And3\", \"name\": \"1–3 года\"}, "
				+ "\"address\": null, "
				+ "\"alternate_url\": \"http://hh.ru/vacancy/7648264\", "
				+ "\"employment\": {\"id\": \"full\", \"name\": \"Полная занятость\"}, "
				+ "\"id\": \"7648264\", "
				+ "\"salary\": {\"to\": 45000, \"from\": null, \"currency\": \"RUR\"}, "
				+ "\"archived\": false, \"name\": \"Торговый представитель\", "
				+ "\"area\": {\"url\": \"https://api.hh.ru/areas/2\", \"id\": \"2\", \"name\": \"Санкт-Петербург\"}, "
				+ "\"created_at\": \"2013-07-01T13:24:33+0400\", "
				+ "\"relations\": [], "
				
				+ "\"employer\": {"
				
				+ "\"logo_urls\": {"
				+ "\"90\": \"http://hh.ru/employer-logo/558938.jpeg\", "
				+ "\"240\": \"http://hh.ru/employer-logo/558939.jpeg\", "
				+ "\"original\": \"http://hh.ru/file/7961138.JPG\"}, "
				
				+ "\"name\": \"Алкон\", "
				+ "\"hrbrand\": null, "
				+ "\"url\": \"https://api.hh.ru/employers/11483\", "
				+ "\"alternate_url\": \"http://hh.ru/employer/11483\", "
				+ "\"id\": \"11483\", "
				+ "\"trusted\": true}, "
				
				+ "\"response_letter_required\": false, "
				+ "\"type\": {\"id\": \"open\", \"name\": \"Открытая\"}, "
				
				+ "\"specializations\": ["
				+ "{\"profarea_id\": \"17\", \"profarea_name\": \"Продажи\", \"id\": \"17.24\", \"name\": \"Алкоголь\"}, "
				+ "{\"profarea_id\": \"17\", \"profarea_name\": \"Продажи\", \"id\": \"17.242\", \"name\": \"Прямые продажи\"}, "
				+ "{\"profarea_id\": \"17\", \"profarea_name\": \"Продажи\", \"id\": \"17.66\", \"name\": \"Дистрибуция\"}, "
				+ "{\"profarea_id\": \"17\", \"profarea_name\": \"Продажи\", \"id\": \"17.196\", \"name\": \"Оптовая торговля\"}, "
				+ "{\"profarea_id\": \"17\", \"profarea_name\": \"Продажи\", \"id\": \"17.302\", \"name\": \"FMCG, Товары народного потребления\"}, "
				+ "{\"profarea_id\": \"15\", \"profarea_name\": \"Начало карьеры, студенты\", \"id\": \"15.389\", \"name\": \"Продажи\"}"
				+ "]}";
//		IParser<Vacancy> parser = new VacancyParser();
//		Vacancy vacancy = parser.parse(requestContent);
//		assertEquals("7648264", vacancy.getId());
	}

}
