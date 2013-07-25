package ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield;

import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.IDictionary;

import java.util.List;

public class ProfessionalFieldDictionary extends Dictionary<ProfessionalField> {
    public ProfessionalFieldDictionary() {
        super(ProfessionalField.NULL_PROFESSIONAL_FIELD);
    }

    public ProfessionalFieldDictionary(List<ProfessionalField> fieldList) throws DictionaryException {
        super(fieldList, ProfessionalField.NULL_PROFESSIONAL_FIELD);
    }

    @Override
    public boolean hasId(String id) {
        if (super.hasId(id)) {
            return true;
        } else {
            for (ProfessionalField field : toList()) {
                IDictionary<Specialization> specializations = field.getSpecializations();
                if (specializations.hasId(id)) return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasName(String name) {
        if (super.hasName(name)) {
            return true;
        } else {
            for (ProfessionalField field : toList()) {
                IDictionary<Specialization> specializations = field.getSpecializations();
                if (specializations.hasName(name)) return true;
            }
        }
        return false;
    }

    @Override
    public ProfessionalField getById(String id) {
        if (super.hasId(id)) {
            return super.getById(id);
        } else {
            for (ProfessionalField field : toList()) {
                IDictionary<Specialization> specializations = field.getSpecializations();
                if (specializations.hasId(id)) return specializations.getById(id);
            }
        }
        return getNullObject(id);
    }

    @Override
    public ProfessionalField getByName(String name) {
        if (super.hasName(name)) {
            return super.getByName(name);
        } else {
            for (ProfessionalField field : toList()) {
                IDictionary<Specialization> specializations = field.getSpecializations();
                if (specializations.hasName(name)) return specializations.getByName(name);
            }
        }
        return getNullObject(name);
    }
}
