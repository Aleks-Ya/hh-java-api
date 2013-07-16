package ru.yaal.project.hhapi.vacancy;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalFieldsForVacancy;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Employment;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Experience;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Schedule;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancyType;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
public class Vacancy {
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private URL url;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private Schedule schedule = Schedule.NULL_SCHEDULE;
    @Getter @Setter
    @SerializedName("accept_handicapped")
    private Boolean acceptHandicapped;
    @Getter @Setter
    private Experience experience = Experience.NULL_EXPERIENCE;
    @Setter
    private Address address = Address.NULL_ADDRESS;
    @Getter @Setter
    @SerializedName("alternate_url")
    private String alternateUrl;
    @Getter @Setter
    private Employment employment = Employment.NULL_EMPLOYMENT;
    @Getter @Setter
    private Salary salary = Salary.NULL_SALARY;
    @Getter @Setter
    private Boolean archived;
    @Getter @Setter
    private Area area = Area.NULL_AREA;
    @Getter @Setter
    @SerializedName("created_at")
    private Date createdAt;
    @Getter @Setter
    private List<Object> relations = new ArrayList<>(0);
    @Getter @Setter
    private Employer employer = Employer.NULL_EMPLOYER;
    @Getter @Setter
    @SerializedName("response_letter_required")
    private Boolean responseLetterRequired;
    @Getter @Setter
    private VacancyType type = VacancyType.NULL_VACANCY_TYPE;
    @Getter @Setter
    private List<ProfessionalFieldsForVacancy> professionalFields = new ArrayList<>(0);

    public Address getAddress(){
        return (address != null) ? address : Address.NULL_ADDRESS;
    }
}
