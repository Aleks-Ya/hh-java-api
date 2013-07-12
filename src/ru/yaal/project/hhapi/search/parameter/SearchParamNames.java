package ru.yaal.project.hhapi.search.parameter;

public enum SearchParamNames {
    TEXT("text"),
    VACANCY_SEARCH_FIELDS("search_field"),
    SCHEDULE("schedule"),
    SALARY("salary"),
    ONLY_WITH_SALARY("only_with_salary"),
    TOP_LAT("top_lat"),
    BOTTOM_LAT("bottom_lat"),
    RIGHT_LNG("right_lng"),
    LEFT_LNG("left_lng"),
    ORDER_BY("order_by"),
    PAGE("page"),
    PER_PAGE("per_page"),
    PERIOD("period");
    private final String name;

    private SearchParamNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
