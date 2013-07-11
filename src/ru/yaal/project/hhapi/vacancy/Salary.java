package ru.yaal.project.hhapi.vacancy;

import lombok.Data;

@Data
public class Salary {
	private Integer from;
	private Integer to;
	private String currency;
}
