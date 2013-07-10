package ru.yaal.project.hhapi.loader;

public class LoadException extends Exception {

    private static final long serialVersionUID = 496234951612172433L;

    public LoadException(Exception e) {
        super(e.getMessage(), e);
    }

}
