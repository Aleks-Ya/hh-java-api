package ru.yaal.project.hhapi.parser;

public interface IParser<T> {
    T parse(String content);
}
