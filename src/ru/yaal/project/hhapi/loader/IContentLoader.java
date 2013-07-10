package ru.yaal.project.hhapi.loader;

public interface IContentLoader {
	String loadContent(final String url) throws LoadException;
	void addParam(String key, String value);
}
