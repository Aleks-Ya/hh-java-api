package ru.yaal.project.hhapi.dictionary.entry.entries.employer;

import ru.yaal.project.hhapi.dictionary.entry.entries.small.SmallDictionariesInitializer;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

public class EmployerType extends AbstractDictionaryEntry {
    public static final EmployerType NULL_EMPLOYER_TYPE = new EmployerType();
    public static final IDictionary<EmployerType> EMPLOYER_TYPES = SmallDictionariesInitializer.getInstance().getEmployerType();
    public static final EmployerType COMPANY = EMPLOYER_TYPES.getById("company");
    public static final EmployerType AGENCY = EMPLOYER_TYPES.getById("agency");
    public static final EmployerType PRIVATE_RECRUITER = EMPLOYER_TYPES.getById("private_recruiter");
}
