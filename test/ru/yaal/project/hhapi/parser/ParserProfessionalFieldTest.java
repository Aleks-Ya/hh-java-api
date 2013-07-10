package ru.yaal.project.hhapi.parser;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalField;

public class ParserProfessionalFieldTest {

	@Test
	public void testParseSpecialization() throws Exception {
		final String content = "{\"specializations\": "
				+ "[{\"id\": \"24.493\", \"name\": \"����������\"}, "
				+ "{\"id\": \"24.492\", \"name\": \"���������\"}, "
				+ "{\"id\": \"24.624\", \"name\": \"�������� ������\"}, "
				+ "{\"id\": \"24.379\", \"name\": \"�������������\"}, "
				+ "{\"id\": \"24.380\", \"name\": \"�������\"}, "
				+ "{\"id\": \"24.378\", \"name\": \"���������� ������\"},"
				+ "{\"id\": \"24.377\", \"name\": \"������������\"}], " + ""
				+ "\"id\": \"24\", "
				+ "\"name\": \"���������� �����, ������, ������ �������\"}";
//		ProfessionalField field = IParser.MAPPER.readValue(content,
//				ProfessionalField.class);
//		assertNotNull(field);
//		assertEquals("24", field.getId());
//		assertEquals("���������� �����, ������, ������ �������",
//				field.getName());
//		assertEquals(7, field.getSpecializations().size());
	}

}
