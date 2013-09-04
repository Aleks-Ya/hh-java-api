package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Уровень доступа к резюме (резюме).
 * @see ru.yaal.project.hhapi.dictionary.Constants.ResumeAccessType
 */
public final class ResumeAccessType extends AbstractDictionaryEntry {
    public static final ResumeAccessType NULL_RESUME_ACCESS_TYPE = new ResumeAccessType();

    private ResumeAccessType() {
    }
}
