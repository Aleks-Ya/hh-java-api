package ru.yaal.project.hhapi.vacancy;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import ru.yaal.project.hhapi.dictionary.entry.IDictionaryEntry;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalFieldsForVacancy;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Employment;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Experience;
import ru.yaal.project.hhapi.dictionary.entry.entries.simple.Schedule;
import ru.yaal.project.hhapi.dictionary.entry.entries.employer.EmployerInVacancy;
import ru.yaal.project.hhapi.dictionary.entry.entries.employer.EmployerSingle;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancyType;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.IContentLoader;
import ru.yaal.project.hhapi.loader.LoadException;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.parser.IParser;
import ru.yaal.project.hhapi.parser.ParseException;
import ru.yaal.project.hhapi.parser.VacancyParser;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.String.format;

public class Vacancy implements IDictionaryEntry {
    public static final Vacancy NULL_VACANCY = new Vacancy();
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private URL url;
    @Setter
    private String description;
    @Setter
    private Schedule schedule = Schedule.NULL_SCHEDULE;
    @Setter
    @SerializedName("accept_handicapped")
    private Boolean acceptHandicapped;
    @Setter
    private Experience experience = Experience.NULL_EXPERIENCE;
    @Setter
    private Address address = Address.NULL_ADDRESS;
    @Getter
    @Setter
    @SerializedName("alternate_url")
    private String alternateUrl;
    @Setter
    private Employment employment = Employment.NULL_EMPLOYMENT;
    private Salary salary = Salary.NULL_SALARY;
    @Setter
    private Boolean archived;
    @Getter
    @Setter
    private Area area = Area.NULL_AREA;
    @Getter
    @Setter
    @SerializedName("created_at")
    private Date createdAt;
    @Getter
    @Setter
    private List<Object> relations = new ArrayList<>(0);
    @Getter
    @Setter
    private EmployerInVacancy employer = EmployerSingle.NULL_EMPLOYER;
    @Getter
    @Setter
    @SerializedName("response_letter_required")
    private Boolean responseLetterRequired;
    @Getter
    @Setter
    private VacancyType type = VacancyType.NULL_VACANCY_TYPE;
    @Setter
    private List<ProfessionalFieldsForVacancy> professionalFields = new ArrayList<>(0);
    private IContentLoader loader = ContentLoaderFactory.newInstanceLongTermCache();
    private IParser<Vacancy> parser = new VacancyParser();
    private boolean singleVacancyLoaded = false;

    public Salary getSalary() {
        if (salary == null) {
            setSalary(Salary.NULL_SALARY);
        }
        assert (salary != null);
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = (salary != null) ? salary : Salary.NULL_SALARY;
        assert (salary != null);
    }

    public Schedule getSchedule() throws LoadException, ParseException {
        loadSingleVacancy();
        return schedule;
    }

    public Boolean getAcceptHandicapped() throws LoadException, ParseException {
        loadSingleVacancy();
        return acceptHandicapped;
    }

    public Experience getExperience() throws LoadException, ParseException {
        loadSingleVacancy();
        return experience;
    }

    public Employment getEmployment() throws LoadException, ParseException {
        loadSingleVacancy();
        return employment;
    }

    public Boolean getArchived() throws LoadException, ParseException {
        loadSingleVacancy();
        return archived;
    }

    public List<ProfessionalFieldsForVacancy> getProfessionalFields() throws LoadException, ParseException {
        loadSingleVacancy();
        return professionalFields;
    }

    public String getDescription() throws LoadException, ParseException {
        loadSingleVacancy();
        return description;
    }

    private void loadSingleVacancy() throws LoadException, ParseException {
        if (!singleVacancyLoaded) {
            String content = loader.loadContent(format(UrlConstants.VACANCY_URL, getId()));
            Vacancy vacancy = parser.parse(content);
            vacancy.singleVacancyLoaded = true;
            setDescription(vacancy.getDescription());
            setSchedule(vacancy.getSchedule());
            setAcceptHandicapped(vacancy.getAcceptHandicapped());
            setExperience(vacancy.getExperience());
            setEmployment(vacancy.getEmployment());
            setArchived(vacancy.getArchived());
            setProfessionalFields(vacancy.getProfessionalFields());
            singleVacancyLoaded = true;
        }
    }

    public Address getAddress() {
        return (address != null) ? address : Address.NULL_ADDRESS;
    }

    @Override
    public boolean isNull() {
        return getId() == null;
    }

    @Override
    public String toString() {
        return format("%s(%s)", getName(), getId());
    }
}
