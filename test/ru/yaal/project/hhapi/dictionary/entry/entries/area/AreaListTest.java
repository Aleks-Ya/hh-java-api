package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import org.junit.Before;
import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Dictionaries;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.loader.FakeContentLoader;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AreaListTest {
    private AreaList areas;

    @Before
    public void before() throws DictionaryException {
        Dictionaries.setLoader(new FakeContentLoader());
        areas = Dictionaries.getArea();
    }

    @Test
    public void testGetEntryById() throws Exception {
        final Area lenOblast = areas.getEntryById("145");
        assertEquals("Ленинградская область", lenOblast.getName());
        assertEquals("231", lenOblast.getParentId());
        List<Area> nestedAreas = lenOblast.getAreas();
        assertEquals(37, nestedAreas.size());
    }

    @Test
    public void testGetFlatMap() throws Exception {
        assertTrue(areas.size() > 500);
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

        Method method = AreaList.class.getDeclaredMethod("treeToFlat",
                List.class);
        method.setAccessible(true);

        AreaList areaList = new AreaList(new ArrayList<Area>(0));

        List<Area> flatList = (List<Area>) method.invoke(areaList, Arrays.asList(area0));
        assertEquals(4, flatList.size());
    }
}
