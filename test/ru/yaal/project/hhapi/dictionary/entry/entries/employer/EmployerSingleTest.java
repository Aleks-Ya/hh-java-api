package ru.yaal.project.hhapi.dictionary.entry.entries.employer;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Constants;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.parser.IParser;
import ru.yaal.project.hhapi.search.SearchException;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class EmployerSingleTest {

    /**
     * todo Тест привязан к реальной компании на сайте, которая может в какой-то момент исчезнуть.
     */
    @Test
    public void employerSingleParse() throws SearchException, MalformedURLException {
        IContentLoader loader = ContentLoaderFactory.newInstanceSortTermCache();
        String content = loader.loadContent(format(UrlConstants.EMPLOYER_URL, "47571"));
        IParser<EmployerSingle> parser = new EmployerParser();
        EmployerSingle employer = parser.parse(content);
        assertEquals("47571", employer.getId());
        assertEquals("SAYENKO KHARENKO", employer.getName());
        assertEquals(Constants.EmployerType.COMPANY, employer.getType());
        assertThat(employer.getDescription(),
                containsString(" is a leading Ukrainian full service law firm"));
        assertEquals(new URL("http://www.sk.ua"), employer.getSiteUrl());
        assertEquals(new URL("https://api.hh.ru/vacancies?employer_id=47571"), employer.getVacanciesUrl());
        assertEquals(new URL("http://hh.ru/employer/47571"), employer.getAlternateUrl());
        LogoUrls logoUrls = employer.getLogoUrls();
        assertEquals(new URL("http://hh.ru/employer-logo/686999.png"), logoUrls.getLogo90());
        assertEquals(new URL("http://hh.ru/employer-logo/687000.png"), logoUrls.getLogo240());
        assertEquals(new URL("http://hh.ru/employer-logo-original/221942.png"), logoUrls.getOriginal());
    }

}
