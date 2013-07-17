package ru.yaal.project.hhapi.loader;

import ru.yaal.project.hhapi.auth.Token;

/**
 * Загружает контент с адресов, требующих авторизацию (информация о текущем пользователе и его резюме).
 * @author Aleks
 *
 */
public class AuthorisedContentLoader extends ContentLoader {

	public AuthorisedContentLoader(Token token) {
		addHeader("Authorization", "Bearer " + token.getAccessToken());
	}
}
