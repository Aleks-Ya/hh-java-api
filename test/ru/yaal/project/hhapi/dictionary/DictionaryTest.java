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
        currency.setName("Рубли");
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
        assertEquals("{Женский(female),Не скажу(unknown),Мужской(male)}", Dictionaries.getGender().toString());
    }

    @Test
    public void toStringAreaDictionary() {
        assertEquals("{Другие страны(1001),Россия(113),Украина(5),Казахстан(40),Азербайджан(9),Беларусь(16)}",
                Dictionaries2.getInstance().getAreas().toString());
    }

    @Test
    public void toStringMetroDictionary() {
        assertEquals("{Екатеринбург(3),Нижний Новгород(66),Санкт-Петербург(2),Днепропетровск(117),Харьков(135)," +
                "Самара(78),Москва(1),Минск(1002),Киев(115),Алматы(160),Новосибирск(4),Казань(88)}",
                Dictionaries2.getInstance().getMetroCities().toString());
        MetroLine line = (MetroLine) Dictionaries2.getInstance().getMetroCities().getByName("Кольцевая");
        assertEquals("{Краснопресненская(5.58),Киевская(5.49),Курская(5.71),Павелецкая(5.102),Октябрьская(5.93)," +
                "Добрынинская(5.36),Парк культуры(5.104),Комсомольская(5.55),Новослободская(5.82),Таганская(5.76)," +
                "Проспект Мира(5.119),Белорусская(5.20)}",
                line.getStations().toString());
    }

    @Test
    public void toStringProfessionalFieldDictionary() {
        assertEquals("{Страхование(19),Продажи(17),Производство(18),Начало карьеры, студенты(15)," +
                "Государственная служба, некоммерческие организации(16),Медицина, фармацевтика(13)," +
                "Наука, образование(14),Искусство, развлечения, масс-медиа(11),Консультирование(12)," +
                "Транспорт, логистика(21),Строительство, недвижимость(20),Туризм, гостиницы, рестораны(22),Юристы(23)," +
                "Спортивные клубы, фитнес, салоны красоты(24),Инсталляция и сервис(25),Закупки(26)," +
                "Домашний персонал(27),Рабочий персонал(29),Маркетинг, реклама, PR(3)," +
                "Бухгалтерия, управленческий учет, финансы предприятия(2)," +
                "Информационные технологии, интернет, телеком(1),Добыча сырья(10),Автомобильный бизнес(7)," +
                "Управление персоналом, тренинги(6),Банки, инвестиции, лизинг(5),Административный персонал(4)," +
                "Высший менеджмент(9),Безопасность(8)}", Dictionaries2.getInstance().getProfessionalFields().toString());
        ProfessionalField field = Dictionaries2.getInstance().getProfessionalFields().getById("19");
        assertEquals("{Эксперт-оценщик(19.357),Агент(19.19),Начальный уровень, Мало опыта(19.170)," +
                "Комплексное страхование физических лиц(19.108),Руководитель направления(19.259),Автострахование(19.18)," +
                "Андеррайтер(19.28),Комплексное страхование юридических лиц(19.109),Перестрахование(19.483)," +
                "Страхование ответственности(19.285),Страхование недвижимости(19.284),Актуарий(19.421)," +
                "Урегулирование убытков(19.430),Врач-эксперт(19.586),Страхование жизни(19.283)," +
                "Страхование бизнеса(19.282),Медицинское страхование(19.147)}", field.getSpecializations().toString());
    }

}
