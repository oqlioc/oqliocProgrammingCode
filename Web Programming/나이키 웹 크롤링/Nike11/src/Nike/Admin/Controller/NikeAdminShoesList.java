package Nike.Admin.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NikeAdminDB.NikeAdminDAO;
import NikeAdminDB.NikeAdminDTO;

public class NikeAdminShoesList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		NikeAdminDAO dao = new NikeAdminDAO();
		ArrayList<NikeAdminDTO> dtos = dao.list();
		request.setAttribute("list", dtos);

		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
   		forward.setPath("./NikeAdmin/Nike_Admin_Shoes_List.jsp");
   		return forward;
	}

}
