package Nike.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NikeAdminDB.NikeAdminDAO;
import NikeAdminDB.NikeAdminDTO;

public class NikeMenShoesJordanList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NikeAdminDAO dao = new NikeAdminDAO();
		ArrayList<NikeAdminDTO> dtos = dao.listJordan();
		request.setAttribute("list", dtos);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./NikeMen/Nike_Men_Shoes_Jordan.jsp");
		return forward;
	}

}
