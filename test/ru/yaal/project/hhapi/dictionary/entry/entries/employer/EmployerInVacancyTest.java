package ru.yaal.project.hhapi.dictionary.entry.entries.employer;

import org.junit.Test;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.parser.IParser;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.Vacancy;
import ru.yaal.project.hhapi.vacancy.VacancyParser;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

public class EmployerInVacancyTest {

    /**
     * todo “ест прив€зан к реальной вакансии на сайте, котора€ может в какой-то момент исчезнуть.
     */
    @Test
    public void employerInVacancyParse() throws SearchException, MalformedURLException {
        IContentLoader loader = ContentLoaderFactory.newInstanceSortTermCache();
        String content = loader.loadContent(format(UrlConstants.VACANCY_URL, "12697071"));
        IParser<Vacancy> parser = new VacancyParser();
        Vacancy vacancy = parser.parse(content);
        EmployerInVacancy employer = vacancy.getEmployer();
        assertEquals("47571", employer.getId());
        assertEquals("SAYENKO KHARENKO", employer.getName());
        assertEquals(new URL("https://api.hh.ru/employers/47571"), employer.getUrl());
        assertEquals(new URL("http://hh.ru/employer/47571"), employer.getAlternateUrl());
        LogoUrls logoUrls = employer.getLogoUrls();
        assertEquals(new URL("http://hh.ru/employer-logo/686999.png"), logoUrls.getLogo90());
        assertEquals(new URL("http://hh.ru/employer-logo/687000.png"), logoUrls.getLogo240());
        assertEquals(new URL("http://hh.ru/employer-logo-original/221942.png"), logoUrls.getOriginal());
    }
}
