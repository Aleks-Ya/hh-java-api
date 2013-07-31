package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.junit.Test;
import ru.yaal.project.hhapi.parser.IParser;

import static org.junit.Assert.assertNotNull;

public class SmallDictionariesParserTest {

    @Test
    public void test() throws Exception {
        final String requestContent = ""
                + "{\"resume_contacts_site_type\": ["
                + "{\"id\": \"personal\", \"name\": \"������ ����\"}, "
                + "{\"id\": \"moi_krug\", \"name\": \"��� ����\"}, "
                + "{\"id\": \"livejournal\", \"name\": \"LiveJournal\"}, "
                + "{\"id\": \"linkedin\", \"name\": \"LinkedIn\"}, "
                + "{\"id\": \"freelance\", \"name\": \"Free-lance\"}, "
                + "{\"id\": \"facebook\", \"name\": \"Facebook\"}, "
                + "{\"id\": \"skype\", \"name\": \"Skype\"}, "
                + "{\"id\": \"icq\", \"name\": \"ICQ\"}, "
                + "{\"id\": \"jabber\", \"name\": \"Jabber\"}], "
                + ""
                + "\"schedule\": ["
                + "{\"id\": \"fullDay\", \"name\": \"������ ����\"}, "
                + "{\"id\": \"shift\", \"name\": \"������� ������\"}, "
                + "{\"id\": \"flexible\", \"name\": \"������ ������\"}, "
                + "{\"id\": \"remote\", \"name\": \"��������� ������\"}], "
                + ""
                + "\"business_trip_readiness\": ["
                + "{\"id\": \"ready\", \"name\": \"����� � �������������\"}, "
                + "{\"id\": \"sometimes\", \"name\": \"����� � ������ �������������\"}, "
                + "{\"id\": \"never\", \"name\": \"�� ����� � �������������\"}], "
                + ""
                + "\"vacancy_search_fields\": ["
                + "{\"id\": \"name\", \"name\": \"� �������� ��������\"}, "
                + "{\"id\": \"company_name\", \"name\": \"� �������� ��������\"}, "
                + "{\"id\": \"description\", \"name\": \"� �������� ��������\"}], "
                + ""
                + "\"currency\": ["
                + "{\"default\": true, \"rate\": 1.0, \"code\": \"RUR\", \"abbr\": \"���.\", \"name\": \"�����\"}, "
                + "{\"default\": false, \"rate\": 0.024628000000000001, \"code\": \"AZN\", \"abbr\": \"AZN\", \"name\": \"������\"}, "
                + "{\"default\": false, \"rate\": 286.13367599999998, \"code\": \"BYR\", \"abbr\": \"���.���.\", \"name\": \"����������� �����\"}, "
                + "{\"default\": false, \"rate\": 0.024961000000000001, \"code\": \"EUR\", \"abbr\": \"EUR\", \"name\": \"����\"}, "
                + "{\"default\": false, \"rate\": 4.6843009999999996, \"code\": \"KZT\", \"abbr\": \"KZT\", \"name\": \"�����\"}, "
                + "{\"default\": false, \"rate\": 0.25418099999999999, \"code\": \"UAH\", \"abbr\": \"���\", \"name\": \"������\"}, "
                + "{\"default\": false, \"rate\": 0.03338, \"code\": \"USD\", \"abbr\": \"USD\", \"name\": \"�������\"}], "
                + ""
                + "\"travel_time\": ["
                + "{\"id\": \"any\", \"name\": \"�� ����� ��������\"}, "
                + "{\"id\": \"less_than_hour\", \"name\": \"�� ����� ����\"}, "
                + "{\"id\": \"from_hour_to_one_and_half\", \"name\": \"�� ����� �������� �����\"}], "
                + ""
                + "\"education_level\": ["
                + "{\"id\": \"higher\", \"name\": \"������\"}, "
                + "{\"id\": \"bachelor\", \"name\": \"��������\"}, "
                + "{\"id\": \"master\", \"name\": \"�������\"}, "
                + "{\"id\": \"candidate\", \"name\": \"�������� ����\"}, "
                + "{\"id\": \"doctor\", \"name\": \"������ ����\"}, "
                + "{\"id\": \"unfinished_higher\", \"name\": \"������������ ������\"}, "
                + "{\"id\": \"secondary\", \"name\": \"�������\"}, "
                + "{\"id\": \"special_secondary\", \"name\": \"������� �����������\"}], "
                + ""
                + "\"relocation_type\": ["
                + "{\"id\": \"no_relocation\", \"name\": \"�� ����� � ��������\"}, "
                + "{\"id\": \"relocation_possible\", \"name\": \"����� � ��������\"}, "
                + "{\"id\": \"relocation_desirable\", \"name\": \"���� ���������\"}], "
                + ""
                + "\"resume_access_type\": ["
                + "{\"id\": \"no_one\", \"name\": \"�������� (������ �� ����� ������)\"}, "
                + "{\"id\": \"whitelist\", \"name\": \"������ ����� ������ ��������� ���������\"}, "
                + "{\"id\": \"blacklist\", \"name\": \"��� ��������, ����� ��������� (������ � ���������� ���������)\"}, "
                + "{\"id\": \"clients\", \"name\": \"����� ������ ������� hh.ru\"}, "
                + "{\"id\": \"everyone\", \"name\": \"����� ����� ���������\"}, "
                + "{\"id\": \"direct\", \"name\": \"������ ����� ������ �� ������ ������\"}], "
                + ""
                + "\"employment\": ["
                + "{\"id\": \"full\", \"name\": \"������ ���������\"}, "
                + "{\"id\": \"part\", \"name\": \"��������� ���������\"}, "
                + "{\"id\": \"project\", \"name\": \"��������� ������\"}, "
                + "{\"id\": \"volunteer\", \"name\": \"������������\"}, "
                + "{\"id\": \"probation\", \"name\": \"����������\"}], "
                + ""
                + "\"vacancy_label\": ["
                + "{\"id\": \"with_address\", \"name\": \"������ � �������\"}, "
                + "{\"id\": \"accept_handicapped\", \"name\": \"������ ��������� ��� ����� � �������������\"}, "
                + "{\"id\": \"not_from_agency\", \"name\": \"��� �������� ��������\"}], "
                + ""
                + "\"gender\": ["
                + "{\"id\": \"unknown\", \"name\": \"�� �����\"}, "
                + "{\"id\": \"male\", \"name\": \"�������\"}, "
                + "{\"id\": \"female\", \"name\": \"�������\"}], "
                + ""
                + "\"language_level\": ["
                + "{\"id\": \"basic\", \"name\": \"������� ������\"}, "
                + "{\"id\": \"can_read\", \"name\": \"����� ���������������� ����������\"}, "
                + "{\"id\": \"can_pass_interview\", \"name\": \"���� ��������� ��������\"}, "
                + "{\"id\": \"fluent\", \"name\": \"�������� ������\"}, "
                + "{\"id\": \"native\", \"name\": \"������\"}], "
                + ""
                + "\"experience\": ["
                + "{\"id\": \"noExperience\", \"name\": \"��� �����\"}, "
                + "{\"id\": \"between1And3\", \"name\": \"�� 1 ���� �� 3 ���\"}, "
                + "{\"id\": \"between3And6\", \"name\": \"�� 3 �� 6 ���\"}, "
                + "{\"id\": \"moreThan6\", \"name\": \"����� 6 ���\"}], "
                + ""
                + "\"preferred_contact_type\": ["
                + "{\"id\": \"home\", \"name\": \"�������� �������\"}, "
                + "{\"id\": \"work\", \"name\": \"������� �������\"}, "
                + "{\"id\": \"cell\", \"name\": \"��������� �������\"}, "
                + "{\"id\": \"email\", \"name\": \"��. �����\"}], "
                + ""
                + "\"vacancy_search_order\": ["
                + "{\"id\": \"publication_time\", \"name\": \"�� ����\"}, "
                + "{\"id\": \"salary_desc\", \"name\": \"�� �������� ��������\"}, "
                + "{\"id\": \"salary_asc\", \"name\": \"�� ����������� ��������\"}, "
                + "{\"id\": \"relevance\", \"name\": \"�� ������������\"}], "
                + ""
                + "\"vacancy_type\": ["
                + "{\"id\": \"open\", \"name\": \"��������\"}, "
                + "{\"id\": \"closed\", \"name\": \"��������\"}, "
                + "{\"id\": \"anonymous\", \"name\": \"���������\"}, "
                + "{\"id\": \"direct\", \"name\": \"� ������ ��������\"}], "
                + ""
                + "\"site_lang\": ["
                + "{\"id\": \"ru\", \"name\": \"��-������\"}, "
                + "{\"id\": \"en\", \"name\": \"In English\"}]}";
        IParser<SmallDictionariesContainer> parser = new SmallDictionariesParser();
        SmallDictionariesContainer dictionaries = parser.parse(requestContent);
        assertNotNull(dictionaries);
    }

}