package ru.yaal.project.hhapi.vacancy;

import java.net.URL;

import com.google.gson.annotations.SerializedName;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import lombok.Data;

@Data
public class Employer extends AbstractDictionaryEntry{
    public static final Employer NULL_EMPLOYER = new Employer();
	@SerializedName("logo_urls")
    private LogoUrls logoUrls;
	private String hrbrand;
	private URL url;
	@SerializedName("alternate_url")
	private URL alternateUrl;
	private Boolean trusted;
}
