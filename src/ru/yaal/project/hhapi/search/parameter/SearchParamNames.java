package ru.yaal.project.hhapi.search.parameter;

public enum SearchParamNames {
    TEXT("text"),
    VACANCY_SEARCH_FIELDS("search_field", true),
    EXPERIENCE("experience"),
    EMPLOYMENT("employment", true),
    SCHEDULE("schedule", true),
    AREA("area", true),
    METRO("metro", true),
    PROFESSIONAL_FIELD("specialization", true),
    EMPLOYER("employer_id", true),
    CURRENCY("currency"),
    SALARY("salary"),
    LABEL("label", true),
    ONLY_WITH_SALARY("only_with_salary"),
    PERIOD("period"),
    TOP_LAT("top_lat"),
    BOTTOM_LAT("bottom_lat"),
    RIGHT_LNG("right_lng"),
    LEFT_LNG("left_lng"),
    ORDER_BY("order_by"),
    PAGE("page"),
    PER_PAGE("per_page");
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
