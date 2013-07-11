package ru.yaal.project.hhapi.search;

import static java.lang.String.format;

public class VacancySearchParams {
	private String text;
	private int perPage = 50;
	/**
	 * ѕредельное количество вакансий на страницу.
	 */
	public static final int PER_PAGE_MAX = 500;
	/**
	 * ћаксимальное количество вакансий в ответе.
	 */
	public static final int MAX_OBJECTS_COUNT = 2000;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		if (perPage > PER_PAGE_MAX) 
			throw new IllegalArgumentException(
					format("ѕревышено количество вакансий на страницу (можно %d, получено %d).", PER_PAGE_MAX, perPage));
		this.perPage = perPage;
	}
	
}
