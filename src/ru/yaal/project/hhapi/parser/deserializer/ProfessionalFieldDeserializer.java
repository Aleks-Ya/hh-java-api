package ru.yaal.project.hhapi.parser.deserializer;

import com.google.gson.*;
import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalField;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalFieldDictionary;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.Specialization;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProfessionalFieldDeserializer implements JsonDeserializer<ProfessionalFieldDictionary> {

    @Override
    public ProfessionalFieldDictionary deserialize(JsonElement element, Type type,
                                                   JsonDeserializationContext context) throws JsonParseException {
        try {
            List<ProfessionalField> fields = new ArrayList<>();
            for (JsonElement field : element.getAsJsonArray()) {
                JsonObject object = (JsonObject) field;
                String id = object.get("id").getAsString();
                if (id != null && !id.isEmpty()) {
                    ProfessionalField newField = new ProfessionalField();
                    newField.setId(id);
                    newField.setName(object.get("name").getAsString());
                    JsonElement specializations = object.get("specializations");
                    if (specializations.isJsonArray()) {
                        List<Specialization> newSpecializations = new ArrayList<>();
                        for (JsonElement specializationElement : specializations.getAsJsonArray()) {
                            JsonObject specialization = (JsonObject) specializationElement;
                            String specId = specialization.get("id").getAsString();
                            if (specId != null && !specId.isEmpty()) {
                                Specialization newSpecialization = new Specialization();
                                newSpecialization.setId(specId);
                                newSpecialization.setName(specialization.get("name").getAsString());
                                newSpecializations.add(newSpecialization);
                            } else {
                                newSpecializations.add(Specialization.NULL_SPECIALIZATION);
                            }
                        }
                        newField.setSpecializations(new Dictionary<>(newSpecializations));
                    }
                    fields.add(newField);
                } else {
                    fields.add(ProfessionalField.NULL_PROFESSIONAL_FIELD);
                }
            }
            return new ProfessionalFieldDictionary(fields);
        } catch (Exception e) {
            throw new JsonParseException(e);
        }
    }
}