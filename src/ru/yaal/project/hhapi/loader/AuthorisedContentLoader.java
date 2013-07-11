package ru.yaal.project.hhapi.loader;

import ru.yaal.project.hhapi.HhToken;

/**
 * ��������� ������� � �������, ��������� ����������� (���������� � ������� ������������ � ��� ������).
 * @author Aleks
 *
 */
public class AuthorisedContentLoader extends ContentLoader {

	public AuthorisedContentLoader(HhToken token) {
		addHeader("Authorization", "Bearer " + token.getAccessToken());
	}
}
