package ru.yaal.project.hhapi.vacancy;

import java.net.URL;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.yaal.project.hhapi.dictionary.entry.entries.Employment;
import ru.yaal.project.hhapi.dictionary.entry.entries.Experience;
import ru.yaal.project.hhapi.dictionary.entry.entries.Schedule;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalFieldsForVacancy;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancyType;

@Data
public class Vacancy {
	private String id;
	private String name;
	private URL url;
	private String description;
	private Schedule schedule;
    @SerializedName("accept_handicapped")
	private Boolean acceptHandicapped;
	private Experience experience;
	private Address address;
    @SerializedName("alternate_url")
	private String alternateUrl;
	private Employment employment;
	private Salary salary;
	private Boolean archived;
	private Area area;
    @SerializedName("created_at")
	private Date createdAt;
	private List<Object> relations;
	private Employer employer;
    @SerializedName("response_letter_required")
	private Boolean responseLetterRequired;
	private VacancyType type;
	private List<ProfessionalFieldsForVacancy> professionalFields;
}
