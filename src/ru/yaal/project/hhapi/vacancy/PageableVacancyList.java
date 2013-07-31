package ru.yaal.project.hhapi.vacancy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.SearchParamNames;
import ru.yaal.project.hhapi.search.parameter.SearchParameterBox;

import java.util.*;

public class PageableVacancyList implements Iterable<IterableVacancyList> {
    private static final Logger LOG = LoggerFactory.getLogger(PageableVacancyList.class);
    private VacancyList firstPage;
    private SearchParameterBox searchParameters;
    private Map<Integer, VacancyList> pagesCache;
    private int vacanciesLimit;

    public PageableVacancyList(VacancyList firstPage, SearchParameterBox searchParameters, int vacanciesLimit) {
        pagesCache = new HashMap<>(firstPage.getPages());
        pagesCache.put(1, firstPage);
        this.firstPage = firstPage;
        this.searchParameters = searchParameters;
        this.vacanciesLimit = vacanciesLimit;
    }

    public IterableVacancyList getVacanciesOnPage(int pageNumber) throws SearchException {
        try {
            if (pageNumber < Page.MIN_PAGE || pageNumber > getPageAmount()) {
                throw new SearchException("Несуществующий номер страницы. Ожидается: %d-%d (включительно). Получено: %d.",
                        Page.MIN_PAGE, getPageAmount(), pageNumber);
            }
            if (pagesCache.containsKey(pageNumber)) {
                return new IterableVacancyList(pagesCache.get(pageNumber));
            } else {
                ISearch<VacancyList> search = new VacancySearch();
                searchParameters.setParameter(SearchParamNames.PAGE, String.valueOf(pageNumber - 1));
                search.addParameter(searchParameters);
                VacancyList vacancyList = search.search();
                pagesCache.put(pageNumber, vacancyList);
                return new IterableVacancyList(pagesCache.get(pageNumber));
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new SearchException(e.getMessage(), e);
        }
    }

    public int getPageAmount() {
        return (getVacanciesAmount() % getVacanciesPerPage() == 0) ? getVacanciesAmount() / getVacanciesPerPage() : getVacanciesAmount() / getVacanciesPerPage() + 1;
    }

    public int getVacanciesAmount() {
        return (firstPage.getFound() > vacanciesLimit) ? vacanciesLimit : firstPage.getFound();
    }

    public int getVacanciesPerPage() {
        return firstPage.getPerPage();
    }

    @Override
    public Iterator<IterableVacancyList> iterator() {
        return new VacancyListIterator();
    }

    public IterableVacancyList toList() throws SearchException {
        try {
            List<Vacancy> fullVacancyList = new ArrayList<>(getVacanciesAmount());
            for (int i = Page.MIN_PAGE; i <= getPageAmount(); i++) {
                IterableVacancyList page = getVacanciesOnPage(i);//загружаем страницы в кэш
                if (fullVacancyList.size() + page.size() > vacanciesLimit) {
                    List<Vacancy> subList = page.toList().subList(0, vacanciesLimit - fullVacancyList.size());
                    fullVacancyList.addAll(subList);
                } else {
                    fullVacancyList.addAll(page.toList());
                }
            }
            return new IterableVacancyList(fullVacancyList);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new SearchException(e);
        }
    }

    class VacancyListIterator implements Iterator<IterableVacancyList> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < getPageAmount();
        }

        @Override
        public IterableVacancyList next() {
            try {
                return getVacanciesOnPage(++cursor);
            } catch (SearchException e) {
                LOG.error(e.getMessage(), e);
                throw new NoSuchElementException(e.getMessage());
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
