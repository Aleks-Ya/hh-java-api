package ru.yaal.project.hhapi.dictionary.entry;

import ru.yaal.project.hhapi.dictionary.Nullable;

public interface IDictionaryEntry extends Nullable {
    String getId();

    void setId(String id);

    String getName();

    void setName(String name);
}
