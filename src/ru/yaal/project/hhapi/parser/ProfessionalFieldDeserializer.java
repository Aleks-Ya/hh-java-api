package ru.yaal.project.hhapi.parser;

import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalField;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalFieldDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.Specialization;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProfessionalFieldDeserializer implements JsonDeserializer<ProfessionalFieldDictionary> {
    private static final Logger LOG = LoggerFactory.getLogger(ProfessionalFieldDeserializer.class);

    @Override
    public ProfessionalFieldDictionary deserialize(JsonElement element, Type type, JsonDeserializationContext context) {
        try {
            List<ProfessionalField> fields = new ArrayList<>();
            for (JsonElement field : element.getAsJsonArray()) {
                JsonObject object = (JsonObject) field;
                fields.add(parseProfessionalField(object));
            }
            return new ProfessionalFieldDictionary(fields);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new JsonParseException(e);
        }
    }

    private ProfessionalField parseProfessionalField(JsonObject object) throws DictionaryException {
        ProfessionalField newField;
        String id = object.get("id").getAsString();
        if (id != null && !id.isEmpty()) {
            newField = new ProfessionalField();
            newField.setId(id);
            newField.setName(object.get("name").getAsString());
            JsonElement specializations = object.get("specializations");
            if (specializations.isJsonArray()) {
                List<Specialization> newSpecializations = new ArrayList<>();
                for (JsonElement specializationElement : specializations.getAsJsonArray()) {
                    JsonObject specialization = (JsonObject) specializationElement;
                    newSpecializations.add(parseSpecialization(specialization));
                }
                newField.setSpecializations(new Dictionary<>(newSpecializations, Specialization.NULL_SPECIALIZATION));
            }
        } else {
            newField = ProfessionalField.NULL_PROFESSIONAL_FIELD;
        }
        return newField;
    }

    private Specialization parseSpecialization(JsonObject specialization) {
        Specialization newSpecialization;
        String specId = specialization.get("id").getAsString();
        if (specId != null && !specId.isEmpty()) {
            newSpecialization = new Specialization();
            newSpecialization.setId(specId);
            newSpecialization.setName(specialization.get("name").getAsString());
        } else {
            newSpecialization = Specialization.NULL_SPECIALIZATION;
        }
        return newSpecialization;
    }
}