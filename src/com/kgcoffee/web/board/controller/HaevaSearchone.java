package com.kgcoffee.web.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgcoffee.web.board.dao.SnsDAO;
import com.kgcoffee.web.board.vo.SnsVO;
import com.kgcoffee.web.common.Paging;


public class HaevaSearchone implements com.kgcoffee.web.common.ControllerImpl {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		SnsDAO sdao1 = new SnsDAO();
		int bunho = Integer.parseInt(request.getParameter("bunho"));                         
		
		String page = request.getParameter("page");
		String searchKeywordType = request.getParameter("searchKeywordType");
		String searchKeyword = request.getParameter("searchKeyword");

		
		request.setAttribute("page", page);
		request.setAttribute("searchKeywordType", searchKeywordType);
		request.setAttribute("searchKeyword", searchKeyword);
	
		System.out.println(bunho);
		SnsVO prePost = sdao1.getPrevious(bunho);
		SnsVO sv1 = sdao1.searchOne(bunho);
		SnsVO nextPost = sdao1.getNext(bunho);

		System.out.println(sv1);
		request.setAttribute("prePost", prePost);
		request.setAttribute("ssv", sv1);
		request.setAttribute("nextPost", nextPost);
		
	}

}
