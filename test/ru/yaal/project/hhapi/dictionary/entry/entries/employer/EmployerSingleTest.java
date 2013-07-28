package ru.yaal.project.hhapi.dictionary.entry.entries.employer;

import org.junit.Test;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.LoadException;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.parser.EmployerParser;
import ru.yaal.project.hhapi.parser.IParser;
import ru.yaal.project.hhapi.parser.ParseException;
import ru.yaal.project.hhapi.vacancy.LogoUrls;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmployerSingleTest {
    @Test
    public void employerSingleParse() throws LoadException, ParseException, MalformedURLException {
        IContentLoader loader = ContentLoaderFactory.newInstanceSortTermCache();
        String content = loader.loadContent(format(UrlConstants.EMPLOYER_URL, "1455"));
        IParser<EmployerSingle> parser = new EmployerParser();
        EmployerSingle employer = parser.parse(content);
        assertEquals("1455", employer.getId());
        assertEquals("HeadHunter", employer.getName());
        assertEquals(EmployerType.COMPANY, employer.getType());
        assertTrue(employer.getDescription().contains("специализируется на предоставлении услуг интернет-рекрутмента"));
        assertEquals(new URL("http://hh.ru"), employer.getSiteUrl());
        assertEquals(new URL("https://api.hh.ru/vacancies?employer_id=1455"), employer.getVacanciesUrl());
        assertEquals(new URL("http://hh.ru/employer/1455"), employer.getAlternateUrl());
        LogoUrls logoUrls = employer.getLogoUrls();
        assertEquals(new URL("http://hh.ru/employer-logo/289027.png"), logoUrls.getLogo90());
        assertEquals(new URL("http://hh.ru/employer-logo/289169.png"), logoUrls.getLogo240());
        assertEquals(new URL("http://hh.ru/file/2352807.png"), logoUrls.getOriginal());
    }

}
