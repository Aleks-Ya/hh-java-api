package ru.yaal.project.hhapi.loader;

import ru.yaal.project.hhapi.HhToken;

/**
 * Загружает контент с адресов, требующих авторизацию (информация о текущем пользователе и его резюме).
 * @author Aleks
 *
 */
public class AuthorisedContentLoader extends ContentLoader {

	public AuthorisedContentLoader(HhToken token) {
		parameters.put("Authorization", "Bearer " + token.getAccessToken());
	}
}
