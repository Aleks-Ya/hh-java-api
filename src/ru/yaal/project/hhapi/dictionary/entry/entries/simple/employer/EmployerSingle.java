package ru.yaal.project.hhapi.dictionary.entry.entries.simple.employer;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

public class EmployerSingle extends EmployerInVacancy {
    public static final EmployerSingle NULL_EMPLOYER = new EmployerSingle();
    @Setter
    private String type;
    @Getter
    @Setter
    @SerializedName("site_url")
    private URL siteUrl;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    @SerializedName("vacancies_url")
    private URL vacanciesUrl;

    public EmployerType getType() {
        return EmployerType.EMPLOYER_TYPES.getById(type);
    }
}
