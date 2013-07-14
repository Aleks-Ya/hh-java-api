package ru.yaal.project.hhapi.parser;

public class ParseException extends Exception {
    public ParseException(Exception e) {
        super(e.getMessage(), e);
    }
}
