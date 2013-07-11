package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper = true)
public class Area extends AbstractDictionaryEntry {
    @SerializedName("parent_id")
    private String parentId;
    private URL url;
    private List<Area> areas = new ArrayList<>(0);
}
