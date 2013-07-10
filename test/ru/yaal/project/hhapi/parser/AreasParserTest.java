package ru.yaal.project.hhapi.parser;

import org.junit.Test;
import ru.yaal.project.hhapi.HhConstants;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.loader.FakeContentLoader;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.LoadException;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class AreasParserTest {

    @Test
    public void test() throws LoadException {
        IContentLoader loader = new FakeContentLoader();
        String content = loader.loadContent(HhConstants.AREAS_URL);
        IParser<List<Area>> parser = new AreasParser();
        List<Area> areas = parser.parse(content);
        assertNotNull(areas);
        assertEquals(6, areas.size());
    }

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

        Method method = AreasParser.class.getDeclaredMethod("areaTreeToFlatList",
                List.class);
        method.setAccessible(true);

        IParser<List<Area>> parse = new AreasParser();

        List<Area> flatList = (List<Area>) method.invoke(parse, Arrays.asList(area0));
        assertEquals(4, flatList.size());
    }

}
