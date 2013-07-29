package ru.yaal.project.hhapi.vacancy;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.net.URL;

@Data
public class LogoUrls {
    @SerializedName("90")
    @SuppressWarnings("PMD.UnusedPrivateField")
    private URL logo90;
    @SerializedName("240")
    @SuppressWarnings("PMD.UnusedPrivateField")
    private URL logo240;
    @SuppressWarnings("PMD.UnusedPrivateField")
    private URL original;
}
