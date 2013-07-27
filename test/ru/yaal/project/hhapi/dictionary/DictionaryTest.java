package ru.yaal.project.hhapi.dictionary;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.currency.Currency;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroLine;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalField;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        IDictionary<Currency> currencies = Dictionaries2.getInstance().getCurrency();
        List<Currency> actualCurrencies = new ArrayList<>(currencies.size());
        for (Currency currency : currencies) {
            actualCurrencies.add(currency);
        }
        List<Currency> expectedCurrencies = currencies.toList();
        assertEquals(expectedCurrencies.size(), actualCurrencies.size());
        assertTrue(actualCurrencies.containsAll(expectedCurrencies));
    }

    @Test
    public void toStringDictionary() {
        assertEquals("{�������(female),�� �����(unknown),�������(male)}", Dictionaries.getGender().toString());
    }

    @Test
    public void toStringAreaDictionary() {
        assertEquals("{������ ������(1001),������(113),�������(5),���������(40),�����������(9),��������(16)}",
                Dictionaries2.getInstance().getAreas().toString());
    }

    @Test
    public void toStringMetroDictionary() {
        assertEquals("{������������(3),������ ��������(66),�����-���������(2),��������������(117),�������(135)," +
                "������(78),������(1),�����(1002),����(115),������(160),�����������(4),������(88)}",
                Dictionaries2.getInstance().getMetroCities().toString());
        MetroLine line = (MetroLine) Dictionaries2.getInstance().getMetroCities().getByName("���������");
        assertEquals("{�����������������(5.58),��������(5.49),�������(5.71),����������(5.102),�����������(5.93)," +
                "������������(5.36),���� ��������(5.104),�������������(5.55),��������������(5.82),���������(5.76)," +
                "�������� ����(5.119),�����������(5.20)}",
                line.getStations().toString());
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
                "������ ����������(9),������������(8)}", Dictionaries2.getInstance().getProfessionalFields().toString());
        ProfessionalField field = Dictionaries2.getInstance().getProfessionalFields().getById("19");
        assertEquals("{�������-�������(19.357),�����(19.19),��������� �������, ���� �����(19.170)," +
                "����������� ����������� ���������� ���(19.108),������������ �����������(19.259),���������������(19.18)," +
                "�����������(19.28),����������� ����������� ����������� ���(19.109),���������������(19.483)," +
                "����������� ���������������(19.285),����������� ������������(19.284),��������(19.421)," +
                "�������������� �������(19.430),����-�������(19.586),����������� �����(19.283)," +
                "����������� �������(19.282),����������� �����������(19.147)}", field.getSpecializations().toString());
    }

}
