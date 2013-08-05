package ru.yaal.project.hhapi.dictionary;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalField;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.SmallDictionariesInitializer;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class DictionaryTest {

    @Test
    public void test() throws DictionaryException {
        Currency currency = Currency.NULL_CURRENCY;
        currency.setId("1");
        currency.setName("�����");
        Dictionary<Currency> currencyDictionary = new Dictionary<>(Currency.NULL_CURRENCY);
        currencyDictionary.addEntry(currency);
        Currency currency2 = currencyDictionary.getById(currency.getId());
        assertEquals(currency, currency2);
    }

    @Test
    public void iterable() {
        IDictionary<Currency> currencies = SmallDictionariesInitializer.getInstance().getCurrency();
        List<Currency> actCurrencies = new ArrayList<>(currencies.size());
        for (Currency currency : currencies) {
            actCurrencies.add(currency);
        }
        List<Currency> expCurrencies = currencies.toList();
        assertThat(actCurrencies, hasSize(expCurrencies.size()));
        assertTrue(actCurrencies.containsAll(expCurrencies));
    }

    @Test
    public void toStringDictionary() {
        assertEquals("{�������(female),�� �����(unknown),�������(male)}",
                SmallDictionariesInitializer.getInstance().getGender().toString());
    }

    @Test
    public void toStringAreaDictionary() {
        assertEquals("{������ ������(1001),������(113),�������(5),���������(40),�����������(9),��������(16)}",
                Area.AREAS.toString());
    }

    @Test
    public void toStringProfessionalFieldDictionary() {
        assertEquals("{�����������(19),�������(17),������������(18),������ �������, ��������(15)," +
                "��������������� ������, �������������� �����������(16),��������, ������������(13)," +
                "�����, �����������(14),���������, �����������, ����-�����(11),����������������(12)," +
                "���������, ���������(21),�������������, ������������(20),������, ���������, ���������(22),������(23)," +
                "���������� �����, ������, ������ �������(24),����������� � ������(25),�������(26)," +
                "�������� ��������(27),������� ��������(29),���������, �������, PR(3)," +
                "�����������, �������������� ����, ������� �����������(2)," +
                "�������������� ����������, ��������, �������(1),������ �����(10),������������� ������(7)," +
                "���������� ����������, ��������(6),�����, ����������, ������(5),���������������� ��������(4)," +
                "������ ����������(9),������������(8)}", ProfessionalField.PROFESSIONAL_FIELDS.toString());
        ProfessionalField field = ProfessionalField.PROFESSIONAL_FIELDS.getById("19");
        assertEquals("{�������-�������(19.357),�����(19.19),��������� �������, ���� �����(19.170)," +
                "����������� ����������� ���������� ���(19.108),������������ �����������(19.259),���������������(19.18)," +
                "�����������(19.28),����������� ����������� ����������� ���(19.109),���������������(19.483)," +
                "����������� ���������������(19.285),����������� ������������(19.284),��������(19.421)," +
                "�������������� �������(19.430),����-�������(19.586),����������� �����(19.283)," +
                "����������� �������(19.282),����������� �����������(19.147)}", field.getSpecializations().toString());
    }

}
