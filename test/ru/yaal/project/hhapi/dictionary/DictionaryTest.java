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
        currency.setName("Рубли");
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
        assertEquals("{Женский(female),Не скажу(unknown),Мужской(male)}",
                SmallDictionariesInitializer.getInstance().getGender().toString());
    }

    @Test
    public void toStringAreaDictionary() {
        assertEquals("{Другие страны(1001),Россия(113),Украина(5),Казахстан(40),Азербайджан(9),Беларусь(16)}",
                Area.AREAS.toString());
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
                "Высший менеджмент(9),Безопасность(8)}", ProfessionalField.PROFESSIONAL_FIELDS.toString());
        ProfessionalField field = ProfessionalField.PROFESSIONAL_FIELDS.getById("19");
        assertEquals("{Эксперт-оценщик(19.357),Агент(19.19),Начальный уровень, Мало опыта(19.170)," +
                "Комплексное страхование физических лиц(19.108),Руководитель направления(19.259),Автострахование(19.18)," +
                "Андеррайтер(19.28),Комплексное страхование юридических лиц(19.109),Перестрахование(19.483)," +
                "Страхование ответственности(19.285),Страхование недвижимости(19.284),Актуарий(19.421)," +
                "Урегулирование убытков(19.430),Врач-эксперт(19.586),Страхование жизни(19.283)," +
                "Страхование бизнеса(19.282),Медицинское страхование(19.147)}", field.getSpecializations().toString());
    }

}
