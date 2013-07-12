package ru.yaal.project.hhapi.parser;

import org.junit.Test;
import ru.yaal.project.hhapi.HhConstants;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.AreaList;
import ru.yaal.project.hhapi.loader.FakeContentLoader;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.LoadException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AreasParserTest {

    @Test
    public void test() throws LoadException {
        IContentLoader loader = new FakeContentLoader();
        String content = loader.loadContent(HhConstants.AREAS_URL);
        IParser<AreaList> parser = new AreasParser();
        IDictionary<Area> areas = parser.parse(content);
        assertNotNull(areas);
        assertEquals(6, areas.size());
    }

}
