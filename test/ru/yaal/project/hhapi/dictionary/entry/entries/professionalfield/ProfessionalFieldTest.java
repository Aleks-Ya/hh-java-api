package ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield;

import org.junit.Test;
import ru.yaal.project.hhapi.TestHelper;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import java.util.List;

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;

public class ProfessionalFieldTest {
    @Test
    public void searchMultiValues() throws Exception {
        final ProfessionalField expectedField1 = ProfessionalField.PROFESSIONAL_FIELDS.getById("18.298");
        final ProfessionalField expectedField2 = ProfessionalField.PROFESSIONAL_FIELDS.getById("22.11");
        for (Vacancy vacancy : TestHelper.search(expectedField1, expectedField2)) {
            List<ProfessionalField> fields = vacancy.getProfessionalFields();
            assertThat(fields, everyItem(isOneOf(expectedField1, expectedField2)));
        }
    }
}
