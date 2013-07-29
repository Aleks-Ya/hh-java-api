package ru.yaal.project.hhapi.dictionary.entry.entries.employer;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.vacancy.LogoUrls;

import java.net.URL;

public class EmployerInVacancy extends EmployerSearchParameter {
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private URL url;
    @Getter
    @Setter
    @SerializedName("alternate_url")
    @SuppressWarnings("PMD.UnusedPrivateField")
    private URL alternateUrl;
    @Getter
    @Setter
    @SerializedName("logo_urls")
    @SuppressWarnings("PMD.UnusedPrivateField")
    private LogoUrls logoUrls;
}
