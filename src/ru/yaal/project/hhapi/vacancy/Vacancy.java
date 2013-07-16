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
	private Experience experience = Experience.NULL_EXPERIENCE;
	private Address address = Address.NULL_ADDRESS;
    @SerializedName("alternate_url")
	private String alternateUrl;
	private Employment employment = Employment.NULL_EMPLOYMENT;
	private Salary salary = Salary.NULL_SALARY;
	private Boolean archived;
	private Area area = Area.NULL_AREA;
    @SerializedName("created_at")
	private Date createdAt;
	private List<Object> relations;
	private Employer employer = Employer.NULL_EMPLOYER;
    @SerializedName("response_letter_required")
	private Boolean responseLetterRequired;
	private VacancyType type = VacancyType.NULL_VACANCY_TYPE;
	private List<ProfessionalFieldsForVacancy> professionalFields;
}
