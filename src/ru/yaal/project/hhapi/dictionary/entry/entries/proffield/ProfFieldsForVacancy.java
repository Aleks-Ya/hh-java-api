package ru.yaal.project.hhapi.dictionary.entry.entries.proffield;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;


public class ProfFieldsForVacancy extends ProfField {
    @Getter
    @Setter
    @SerializedName("profarea_id")
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String profareaId;
    @Getter
    @Setter
    @SerializedName("profarea_name")
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String profareaName;
}
