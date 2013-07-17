package ru.yaal.project.hhapi.search;

import static java.lang.String.format;

public class SearchException extends Exception {
    private static final long serialVersionUID = -945529631039095249L;

    public SearchException(Exception e) {
        super(e.getMessage(), e);
    }

    public SearchException(String message, Object... args) {
        super(format(message, args));
    }
}
