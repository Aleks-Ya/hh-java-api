package ru.yaal.project.hhapi.dictionary;

import static java.lang.String.format;

public class DictionaryException extends Exception {
    private static final long serialVersionUID = -8329654964740843540L;

    public DictionaryException(Exception e) {
        super(e.getMessage(), e);
    }

    public DictionaryException(String message, Object... args) {
        super(format(message, args));
    }
}
