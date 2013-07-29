package ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ProfessionalFieldsForVacancy extends ProfessionalField {
    @SerializedName("profarea_id")
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String profareaId;
    @SerializedName("profarea_name")
    @SuppressWarnings("PMD.UnusedPrivateField")
    private String profareaName;
}
