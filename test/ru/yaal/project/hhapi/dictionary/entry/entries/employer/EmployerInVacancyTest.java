package ru.yaal.project.hhapi.dictionary.entry.entries.employer;

import org.junit.Test;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.LoadException;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.parser.IParser;
import ru.yaal.project.hhapi.parser.ParseException;
import ru.yaal.project.hhapi.parser.VacancyParser;
import ru.yaal.project.hhapi.vacancy.LogoUrls;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

public class EmployerInVacancyTest {

    @Test
    public void employerInVacancyParse() throws LoadException, ParseException, MalformedURLException {
        IContentLoader loader = ContentLoaderFactory.newInstanceSortTermCache();
        String content = loader.loadContent(format(UrlConstants.VACANCY_URL, "8252535"));
        IParser<Vacancy> parser = new VacancyParser();
        Vacancy vacancy = parser.parse(content);
        EmployerInVacancy employer = vacancy.getEmployer();
        assertEquals("1455", employer.getId());
        assertEquals("HeadHunter", employer.getName());
        assertEquals(new URL("https://api.hh.ru/employers/1455"), employer.getUrl());
        assertEquals(new URL("http://hh.ru/employer/1455"), employer.getAlternateUrl());
        LogoUrls logoUrls = employer.getLogoUrls();
        assertEquals(new URL("http://hh.ru/employer-logo/289027.png"), logoUrls.getLogo90());
        assertEquals(new URL("http://hh.ru/employer-logo/289169.png"), logoUrls.getLogo240());
        assertEquals(new URL("http://hh.ru/file/2352807.png"), logoUrls.getOriginal());
    }
}
