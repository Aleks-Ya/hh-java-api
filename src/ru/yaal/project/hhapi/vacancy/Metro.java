package ru.yaal.project.hhapi.vacancy;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.yaal.project.hhapi.dictionary.INullable;

@Data
public class Metro implements INullable {
    public static final Metro NULL_METRO = new Metro();
    @SerializedName("station_id")
    private String metroId;

    @Override
    public boolean isNull() {
        return (metroId == null || metroId.isEmpty());
    }
}
