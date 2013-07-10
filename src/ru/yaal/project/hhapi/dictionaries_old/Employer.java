package ru.yaal.project.hhapi.dictionaries_old;

import java.net.URL;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import lombok.Data;

@Data
public class Employer extends AbstractDictionaryEntry{
	private LogoUrls logo_urls;
	private String hrbrand;
	private URL url;
	private URL alternate_url;
	private Boolean trusted;
}
