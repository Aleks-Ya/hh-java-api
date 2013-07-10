package ru.yaal.project.hhapi.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ru.yaal.project.hhapi.Vacancy;

public class VacancyParserTest {

	@Test
	public void test() throws Exception {
		final String content = "{\"description\": \"�����������:\", \"schedule\": {\"id\": \"flexible\", \"name\": \"������ ������\"}, \"accept_handicapped\": false, \"experience\": {\"id\": \"noExperience\", \"name\": \"�� ���������\"}, \"address\": null, \"alternate_url\": \"http://hh.ru/vacancy/7149894\", \"employment\": {\"id\": \"part\", \"name\": \"��������� ���������\"}, \"id\": \"7149894\", \"salary\": {\"to\": 100000, \"from\": 30000, \"currency\": \"RUR\"}, \"archived\": false, \"name\": \"�������� (� ������ �����������)\", \"area\": {\"url\": \"https://api.hh.ru/areas/1\", \"id\": \"1\", \"name\": \"������\"}, \"created_at\": \"2013-07-07T18:53:35+0400\", \"relations\": [], \"employer\": {\"logo_urls\": {\"90\": \"http://hh.ru/employer-logo/722384.jpeg\", \"240\": \"http://hh.ru/employer-logo/722385.jpeg\", \"original\": \"http://hh.ru/file/9347463.jpg\"}, \"name\": \"������, ���\", \"url\": \"https://api.hh.ru/employers/622731\",\"alternate_url\": \"http://hh.ru/employer/622731\", \"id\": \"622731\", \"trusted\": true}, \"response_letter_required\": false, \"type\": {\"id\": \"open\", \"name\": \"��������\"}, \"specializations\": [{\"profarea_id\": \"21\", \"profarea_name\": \"���������, ��,\"id\": \"21.482\", \"name\": \"��������\"}]}";
//		IParser<Vacancy> parser = new VacancyParser();
//		Vacancy vacancy = parser.parse(content);
//		assertNotNull(vacancy);
//		assertEquals("7149894", vacancy.getId());
//		assertEquals("�������� (� ������ �����������)", vacancy.getName());
	}

}
