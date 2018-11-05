package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.dao.SignDao;
import com.javalec.ex.dto.SignDto;

public class SignMypageCommand implements SignCommand{

	 @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) {
	      // TODO Auto-generated method stub

	      HttpSession session = request.getSession();
	      // session���� �����Ǿ� �ִ� id�� ������
	      String userID = (String) session.getAttribute("idSession");

	      SignDao dao = new SignDao();
	      SignDto dto = dao.PageEdit(userID);
	      
	      request.setAttribute("Mypage_view", dto);
	   }
}
