package com.kgcoffee.web.voc.vervice;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgcoffee.web.voc.dao.VocDAO;

public class VocUpHItService implements VocImpli {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String bunho = request.getParameter("bunho");
		
		Cookie[] cookies = request.getCookies();
		
		boolean flag = true;
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals(bunho+"2")) { // 쿠키이름이 게시글 조회번호와 동일한지 검사
					flag = false; // 중복의 의미
					break;
				}
			}
		}
	
		if(flag) { // 중복이 없다면 true
			// DAO연결 조회수증가
			VocDAO.getInstance().upHit(bunho);
			
			// 1. 마지막에 조회된 글 번호를 쿠키로 생성해서, 클라이언트 측으로 전송
			Cookie cookie = new Cookie(bunho+"2", bunho); // 쿠키형식( 1:1 , 2:2 ).....
			cookie.setMaxAge(60*60*24); // 30초 수명설정
			response.addCookie(cookie);
			
			
		}
		
	
		
	}

	

}
