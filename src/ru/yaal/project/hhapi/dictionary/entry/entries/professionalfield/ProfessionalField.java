package ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield;

import java.util.List;

import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import lombok.Data;

@Data
public class ProfessionalField extends AbstractDictionaryEntry {
	protected List<Specialization> specializations;
}
