package ru.yaal.project.hhapi.parser;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;

public class AreasParserTest {

	@Test
	public void testAreaTreeToFlatList() throws Exception {
		Area area0_1 = new Area();
		area0_1.setId("01");
		area0_1.setName("Санкт-Петербург");

		
		Area area0_2_1 = new Area();
		area0_2_1.setId("021");
		area0_2_1.setName("Кириллов");

		Area area0_2 = new Area();
		area0_1.setId("02");
		area0_1.setName("Вологда");
		area0_2.setAreas(Arrays.asList(area0_2_1));

		Area area0 = new Area();
		area0.setId("00");
		area0.setName("Россия");
		area0.setAreas(Arrays.asList(area0_1, area0_2));
		
//		Method method = AreasParser.class.getDeclaredMethod("areaTreeToFlatList",
//				List.class);
//		method.setAccessible(true);
//
//		IParser<Dictionary<Area>> parser = new AreasParser();
//		
//		List<Area> flatList = (List<Area>) method.invoke(parser, Arrays.asList(area0));
//		assertEquals(4, flatList.size());
	}

}
