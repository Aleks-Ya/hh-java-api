package ru.yaal.project.hhapi.dictionary.entry.entries.proffield;

import org.junit.Test;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.parser.IParser;

import static org.junit.Assert.assertTrue;

public class ParserProfFieldTest {

    @Test
    public void testParseSpecialization() throws Exception {
        String content = ContentLoaderFactory.newInstanceLongTermCache().loadContent(UrlConstants.SPECIALIZATIONS_URL);
        IParser<ProfFieldDictionary> parser = new ProfFieldsParser();
        ProfFieldDictionary dictionary = parser.parse(content);
        assertTrue(dictionary.hasId("24.492"));
        assertTrue(dictionary.hasName("Массажист"));
    }

}
