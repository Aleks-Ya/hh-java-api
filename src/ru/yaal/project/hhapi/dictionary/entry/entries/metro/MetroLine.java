package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

import java.util.List;

@Data
public class MetroLine extends AbstractDictionaryEntry {
    @SerializedName("hex_color")
    private String hexColor;
    private List<MetroStation> stations;
}
