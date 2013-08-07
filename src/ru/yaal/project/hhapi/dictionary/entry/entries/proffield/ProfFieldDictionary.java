package ru.yaal.project.hhapi.dictionary.entry.entries.proffield;

import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.IDictionary;

import java.util.List;

public class ProfFieldDictionary extends Dictionary<ProfField> {
    public ProfFieldDictionary() {
        super(ProfField.NULL_PROF_FIELD);
    }

    public ProfFieldDictionary(List<ProfField> fieldList) {
        super(fieldList, ProfField.NULL_PROF_FIELD);
    }

    @Override
    public boolean hasId(String id) {
        if (super.hasId(id)) {
            return true;
        } else {
            for (ProfField field : toList()) {
                IDictionary<Specialization> specializations = field.getSpecializations();
                if (specializations.hasId(id)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasName(String name) {
        if (super.hasName(name)) {
            return true;
        } else {
            for (ProfField field : toList()) {
                IDictionary<Specialization> specializations = field.getSpecializations();
                if (specializations.hasName(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public ProfField getById(String id) {
        if (super.hasId(id)) {
            return super.getById(id);
        } else {
            for (ProfField field : toList()) {
                IDictionary<Specialization> specializations = field.getSpecializations();
                if (specializations.hasId(id)) {
                    return specializations.getById(id);
                }
            }
        }
        return getNullObject(id);
    }

    @Override
    public ProfField getByName(String name) {
        if (super.hasName(name)) {
            return super.getByName(name);
        } else {
            for (ProfField field : toList()) {
                IDictionary<Specialization> specializations = field.getSpecializations();
                if (specializations.hasName(name)) {
                    return specializations.getByName(name);
                }
            }
        }
        return getNullObject(name);
    }
}
