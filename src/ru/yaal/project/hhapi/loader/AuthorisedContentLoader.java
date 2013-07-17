package ru.yaal.project.hhapi.loader;

import ru.yaal.project.hhapi.auth.Token;

/**
 * ��������� ������� � �������, ��������� ����������� (���������� � ������� ������������ � ��� ������).
 * @author Aleks
 *
 */
public class AuthorisedContentLoader extends ContentLoader {

	public AuthorisedContentLoader(Token token) {
		addHeader("Authorization", "Bearer " + token.getAccessToken());
	}
}
