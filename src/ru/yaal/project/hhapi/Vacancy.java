package ru.yaal.project.hhapi;

import java.net.URL;
import java.util.Date;
import java.util.List;

import lombok.Data;
import ru.yaal.project.hhapi.dictionaries_old.Employer;
import ru.yaal.project.hhapi.dictionaries_old.Salary;
import ru.yaal.project.hhapi.dictionaries_old.Type;
import ru.yaal.project.hhapi.dictionary.entry.entries.Employment;
import ru.yaal.project.hhapi.dictionary.entry.entries.Experience;
import ru.yaal.project.hhapi.dictionary.entry.entries.Schedule;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalFieldsForVacancy;

@Data
public class Vacancy {
	private String id;
	private String name;
	private URL url;
	private String description;
	private Schedule schedule;
	private Boolean accept_handicapped;
	private Experience experience;
	private String address;
	private String alternate_url;
	private Employment employment;
	private Salary salary;
	private Boolean archived;
	private Area area;
	private Date created_at;
	private List<Object> relations;
	private Employer employer;
	private Boolean response_letter_required;
	private Type type;
	private List<ProfessionalFieldsForVacancy> professionalFields;
}
