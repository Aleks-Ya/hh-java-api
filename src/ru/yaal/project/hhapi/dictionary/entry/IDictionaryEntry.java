package ru.yaal.project.hhapi.dictionary.entry;

import ru.yaal.project.hhapi.dictionary.INullable;

public interface IDictionaryEntry extends INullable {
    String getId();

    void setId(String id);

    String getName();

    void setName(String name);
}
