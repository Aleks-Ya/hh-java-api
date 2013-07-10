package ru.yaal.project.hhapi.parser;

import org.junit.Test;

public class VacancyParser2Test {

	@Test
	public void test() {
		final String requestContent = "{\"description\": \"<p> � ����� � ����������� ������� ������ �������� &quot;�����&quot; ��������� ������� �� �������� <strong>�������� ��������������</strong><strong>�</strong></p> <p> <strong>�����������:</strong></p> <ul> <li> ����������� � �������� ���������� ���� (�������)</li> <li> ������������ ����������� �������������</li> <li> ����������</li> <li> �������������</li> </ul> <p> <strong>����������:</strong></p> <ul> <li> �������/�������, 21-45 ���</li> <li> �������� ��� ��� ���.�������</li> <li> ������� ���������� �����������</li> <li> ���� ������</li> <li> ������������������,��������������</li> </ul> <p> <strong>�������:</strong></p> <ul> <li> ������ � ������� �������� ��������</li> <li> ���������� �� �� ��</li> <li> ������ ������ 5/2 � 09.00-18.00</li> <li> ���� �.��������</li> </ul>\", "
				+ "\"schedule\": {\"id\": \"fullDay\", \"name\": \"������ ����\"}, "
				+ "\"accept_handicapped\": false, "
				+ "\"experience\": {\"id\": \"between1And3\", \"name\": \"1�3 ����\"}, "
				+ "\"address\": null, "
				+ "\"alternate_url\": \"http://hh.ru/vacancy/7648264\", "
				+ "\"employment\": {\"id\": \"full\", \"name\": \"������ ���������\"}, "
				+ "\"id\": \"7648264\", "
				+ "\"salary\": {\"to\": 45000, \"from\": null, \"currency\": \"RUR\"}, "
				+ "\"archived\": false, \"name\": \"�������� �������������\", "
				+ "\"area\": {\"url\": \"https://api.hh.ru/areas/2\", \"id\": \"2\", \"name\": \"�����-���������\"}, "
				+ "\"created_at\": \"2013-07-01T13:24:33+0400\", "
				+ "\"relations\": [], "
				
				+ "\"employer\": {"
				
				+ "\"logo_urls\": {"
				+ "\"90\": \"http://hh.ru/employer-logo/558938.jpeg\", "
				+ "\"240\": \"http://hh.ru/employer-logo/558939.jpeg\", "
				+ "\"original\": \"http://hh.ru/file/7961138.JPG\"}, "
				
				+ "\"name\": \"�����\", "
				+ "\"hrbrand\": null, "
				+ "\"url\": \"https://api.hh.ru/employers/11483\", "
				+ "\"alternate_url\": \"http://hh.ru/employer/11483\", "
				+ "\"id\": \"11483\", "
				+ "\"trusted\": true}, "
				
				+ "\"response_letter_required\": false, "
				+ "\"type\": {\"id\": \"open\", \"name\": \"��������\"}, "
				
				+ "\"specializations\": ["
				+ "{\"profarea_id\": \"17\", \"profarea_name\": \"�������\", \"id\": \"17.24\", \"name\": \"��������\"}, "
				+ "{\"profarea_id\": \"17\", \"profarea_name\": \"�������\", \"id\": \"17.242\", \"name\": \"������ �������\"}, "
				+ "{\"profarea_id\": \"17\", \"profarea_name\": \"�������\", \"id\": \"17.66\", \"name\": \"�����������\"}, "
				+ "{\"profarea_id\": \"17\", \"profarea_name\": \"�������\", \"id\": \"17.196\", \"name\": \"������� ��������\"}, "
				+ "{\"profarea_id\": \"17\", \"profarea_name\": \"�������\", \"id\": \"17.302\", \"name\": \"FMCG, ������ ��������� �����������\"}, "
				+ "{\"profarea_id\": \"15\", \"profarea_name\": \"������ �������, ��������\", \"id\": \"15.389\", \"name\": \"�������\"}"
				+ "]}";
//		IParser<Vacancy> parser = new VacancyParser();
//		Vacancy vacancy = parser.parse(requestContent);
//		assertEquals("7648264", vacancy.getId());
	}

}
