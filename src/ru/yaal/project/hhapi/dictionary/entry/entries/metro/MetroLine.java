package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

@Data
public class MetroLine extends AbstractDictionaryEntry {
    public static final MetroLine NULL_METRO_LINE = new MetroLine();
    @SerializedName("hex_color")
    private String hexColor;
    private IDictionary<MetroStation> stations;
    private MetroCity city;
}
