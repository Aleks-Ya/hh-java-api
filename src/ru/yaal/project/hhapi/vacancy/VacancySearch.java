package ru.yaal.project.hhapi.vacancy;

import ru.yaal.project.hhapi.search.SearchException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static ru.yaal.project.hhapi.vacancy.PerPage.MAX_PER_PAGE;

public class VacancySearch extends AbstractSearch<VacancyList> {
    private final int vacancyLimit;
    private final List<Vacancy> vacancies = new ArrayList<>();

    public VacancySearch() {
        this(DEFAULT_VACANCIES_LIMIT);
    }

    public VacancySearch(int vacancyLimit) {
        if (vacancyLimit < MIN_VACANCIES_LIMIT || vacancyLimit > MAX_VACANCIES_LIMIT) {
            throw new IllegalArgumentException(format(
                    "Количество вакансий может быть в пределах от %d до %d. Получено: %d.",
                    MIN_VACANCIES_LIMIT, MAX_VACANCIES_LIMIT, vacancyLimit));
        }
        this.vacancyLimit = vacancyLimit;
    }

    @Override
    public VacancyList search() throws SearchException {
        if (vacancyLimit <= MAX_PER_PAGE) {
            VacancyPage page = new VacancyPageSearch()
                    .addParameter(new PerPage(vacancyLimit))
                    .addParameter(getParameterBox())
                    .search();
            vacancies.addAll(page.getItems());
        } else {
            int lastLimit = vacancyLimit;
            int pageNum = 1;
            do {
                VacancyPage page = new VacancyPageSearch()
                        .addParameter(new PerPage(MAX_PER_PAGE))
                        .addParameter(new Page(pageNum))
                        .addParameter(getParameterBox())
                        .search();
                vacancies.addAll(page.getItems());
                pageNum++;
                lastLimit -= MAX_PER_PAGE;
            } while (lastLimit > 0);
        }
        return new VacancyList(vacancies);
    }
}
