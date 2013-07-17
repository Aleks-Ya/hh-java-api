package ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield;

import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.IDictionary;

import java.util.List;

public class ProfessionalFieldDictionary extends Dictionary<ProfessionalField> {
    public ProfessionalFieldDictionary(List<ProfessionalField> fieldList) throws DictionaryException {
        super(fieldList);
    }

    @Override
    public boolean hasEntryWithId(String id) throws DictionaryException {
        if (super.hasEntryWithId(id)) {
            return true;
        } else {
            for (ProfessionalField field : toList()) {
                IDictionary<Specialization> specializations = field.getSpecializations();
                if (specializations.hasEntryWithId(id)) return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasEntryWithName(String name) throws DictionaryException {
        if (super.hasEntryWithName(name)) {
            return true;
        } else {
            for (ProfessionalField field : toList()) {
                IDictionary<Specialization> specializations = field.getSpecializations();
                if (specializations.hasEntryWithName(name)) return true;
            }
        }
        return false;
    }

    @Override
    public ProfessionalField getEntryById(String id) throws DictionaryException {
        if (super.hasEntryWithId(id)) {
            return super.getEntryById(id);
        } else {
            for (ProfessionalField field : toList()) {
                IDictionary<Specialization> specializations = field.getSpecializations();
                if (specializations.hasEntryWithId(id)) return specializations.getEntryById(id);
            }
        }
        throw new DictionaryException("В словаре не найдено значение по ключу \"%s\".", id);
    }

    @Override
    public ProfessionalField getEntryByName(String name) throws DictionaryException {
        if (super.hasEntryWithName(name)) {
            return super.getEntryByName(name);
        } else {
            for (ProfessionalField field : toList()) {
                IDictionary<Specialization> specializations = field.getSpecializations();
                if (specializations.hasEntryWithName(name)) return specializations.getEntryByName(name);
            }
        }
        throw new DictionaryException("В словаре не найдено значение по имени \"%s\".", name);
    }
}
