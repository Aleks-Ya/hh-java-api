package ru.yaal.project.hhapi.search.parameter;

public enum SearchParamNames {
    TEXT("text"),
    VACANCY_SEARCH_FIELDS("search_field"),
    SCHEDULE("schedule"),
    ONLY_WITH_SALARY("only_with_salary");
    private final String name;

    private SearchParamNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
