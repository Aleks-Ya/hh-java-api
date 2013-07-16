package ru.yaal.project.hhapi.dictionary.entry;

import ru.yaal.project.hhapi.dictionary.IDictionary;

public interface ITreeDictionaryEntry {
    IDictionary<? extends IDictionaryEntry> getNested();
}
