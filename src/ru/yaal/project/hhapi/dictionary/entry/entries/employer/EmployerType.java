package ru.yaal.project.hhapi.dictionary.entry.entries.employer;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

/**
 * Тип работодателя.
 * @see ru.yaal.project.hhapi.dictionary.Constants.EmployerType
 */
public class EmployerType extends AbstractDictionaryEntry {
    public static final EmployerType NULL_EMPLOYER_TYPE = new EmployerType();

    private EmployerType() {
    }
}
