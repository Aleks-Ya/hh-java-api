package ru.yaal.project.hhapi.dictionary.entry.entries.employer;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.dictionary.Constants;


import java.net.URL;

public class EmployerSingle extends EmployerInVacancy {
    public static final EmployerSingle NULL_EMPLOYER = new EmployerSingle();
    @Setter
    private String type;
    @Getter
    @Setter
    @SerializedName("site_url")
    @SuppressWarnings("PMD.UnusedPrivateField")
    private URL siteUrl;
    @Getter
    @Setter
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String description;
    @Getter
    @Setter
    @SerializedName("vacancies_url")
    @SuppressWarnings("PMD.UnusedPrivateField")
    private URL vacanciesUrl;

    public EmployerType getType() {
        return Constants.EmployerType.EMPLOYER_TYPES.getById(type);
    }
}
