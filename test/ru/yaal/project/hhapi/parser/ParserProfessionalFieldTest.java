package ru.yaal.project.hhapi.parser;

import static org.junit.Assert.*;

import org.junit.Test;

import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalField;

public class ParserProfessionalFieldTest {

	@Test
	public void testParseSpecialization() throws Exception {
		final String content = "{\"specializations\": "
				+ "[{\"id\": \"24.493\", \"name\": \"Парикмахер\"}, "
				+ "{\"id\": \"24.492\", \"name\": \"Массажист\"}, "
				+ "{\"id\": \"24.624\", \"name\": \"Ногтевой сервис\"}, "
				+ "{\"id\": \"24.379\", \"name\": \"Администрация\"}, "
				+ "{\"id\": \"24.380\", \"name\": \"Продажи\"}, "
				+ "{\"id\": \"24.378\", \"name\": \"Тренерский состав\"},"
				+ "{\"id\": \"24.377\", \"name\": \"Косметология\"}], " + ""
				+ "\"id\": \"24\", "
				+ "\"name\": \"Спортивные клубы, фитнес, салоны красоты\"}";
//		ProfessionalField field = IParser.MAPPER.readValue(content,
//				ProfessionalField.class);
//		assertNotNull(field);
//		assertEquals("24", field.getId());
//		assertEquals("Спортивные клубы, фитнес, салоны красоты",
//				field.getName());
//		assertEquals(7, field.getSpecializations().size());
	}

}
