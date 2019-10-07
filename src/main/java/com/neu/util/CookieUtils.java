package com.neu.util;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.entity.ShoppingCart;

public class CookieUtils {
	public String getCookie(HttpServletRequest request, String cookieName) {

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieName)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	public void writeCookie(HttpServletResponse response, String shoppingCart, ShoppingCart cart) {
		Cookie cookie = new Cookie(shoppingCart, cart.toString());
		cookie.setPath("/");
		cookie.setMaxAge(5 * 60);
		response.addCookie(cookie);
	}
}
