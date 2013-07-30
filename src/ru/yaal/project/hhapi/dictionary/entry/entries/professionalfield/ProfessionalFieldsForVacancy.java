package ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;


public class ProfessionalFieldsForVacancy extends ProfessionalField {
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
