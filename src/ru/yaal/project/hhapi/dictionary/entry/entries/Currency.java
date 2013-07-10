package ru.yaal.project.hhapi.dictionary.entry.entries;

import lombok.Data;
import lombok.ToString;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;

@Data
@ToString(callSuper=true)
public class Currency extends AbstractDictionaryEntry{

	//TODO isDefault --> getIsDefault() ���������
	private Boolean isDefault;

	private Double rate;

	/**
	 * �������� code �� id. 
	 */
	@Override
	public void setId(String id) {
		super.setId(id);
	}
	private String abbr;
	
}
