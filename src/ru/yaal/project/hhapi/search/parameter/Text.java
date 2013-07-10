package ru.yaal.project.hhapi.search.parameter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.yaal.project.hhapi.dictionary.entry.entries.VacancySearchFields;

public class Text implements ISearchParameter {
	public static final String TEXT_PARAM_NAME = "search_field";
	public static final String VACANCY_SEARCH_FIELDS_PARAM_NAME = "search_field";
	private String text = "";
	private List<VacancySearchFields> fields = new ArrayList<>();

	public Text(String text) {
		this.text = text;
	}

	@Override
	public Map<String, String> getSearchParameters() {
		Map<String, String> params = new HashMap<>();
		params.put(TEXT_PARAM_NAME, text);
		for(VacancySearchFields field : fields){
			params.put(VACANCY_SEARCH_FIELDS_PARAM_NAME, field.getId());
			//TODO перетрет, если несколько полей задано
		}
		return params;
	}

}
