package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Образование (резюме).
 * @see ru.yaal.project.hhapi.dictionary.Constants.EducationLevel
 */
public final class EducationLevel extends AbstractDictionaryEntry {
    public static final EducationLevel NULL_EDUCATION_LEVEL = new EducationLevel();

    private EducationLevel() {
    }
}
