package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Уровень владения языком (резюме).
 */
public final class LanguageLevel extends AbstractDictionaryEntry {
    public static final LanguageLevel NULL_LANGUAGE_LEVEL = new LanguageLevel();

    private LanguageLevel() {
    }
}
