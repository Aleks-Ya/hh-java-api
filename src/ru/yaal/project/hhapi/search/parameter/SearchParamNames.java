package ru.yaal.project.hhapi.search.parameter;

public enum SearchParamNames {
    TEXT("text"),
    VACANCY_SEARCH_FIELDS("search_field", true),
    SCHEDULE("schedule", true),
    SALARY("salary"),
    ONLY_WITH_SALARY("only_with_salary"),
    TOP_LAT("top_lat"),
    BOTTOM_LAT("bottom_lat"),
    RIGHT_LNG("right_lng"),
    LEFT_LNG("left_lng"),
    ORDER_BY("order_by"),
    PAGE("page"),
    PER_PAGE("per_page"),
    PERIOD("period"),
    EXPERIENCE("experience"),
    METRO("metro", true),
    AREA("area", true),
    PROFESSIONAL_FIELD("specialization", true),
    EMPLOYMENT("employment", true),
    EMPLOYER("employer_id", true),
    LABEL("label", true);
    private final String name;
    private boolean acceptMultipleValues;

    private SearchParamNames(String name) {
        this(name, false);
    }

    private SearchParamNames(String name, boolean acceptMultipleValues) {
        this.name = name;
        this.acceptMultipleValues = acceptMultipleValues;
    }

    public String getName() {
        return name;
    }

    public boolean acceptMultipleVales() {
        return acceptMultipleValues;
    }

}
