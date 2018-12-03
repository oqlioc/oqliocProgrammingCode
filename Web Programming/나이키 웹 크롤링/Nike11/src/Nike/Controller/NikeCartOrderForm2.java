package Nike.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import NikeAdminDB.NikeAdminDAO;
import NikeAdminDB.NikeAdminDTO;

public class NikeCartOrderForm2 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		ActionForward forward = new ActionForward();

		String email1 = "";
		String itemnum1 = "";
		String title1 = "";
		int price1 = 0;
		String board1 = "";
		int num1 = 0;
		String pic1 = "";
		String pic2 = "";
		String content1 = "";
		String category1 = "";
		
		String nikename1 = "";
		String nikephone1 = "";
		String nikeaddress1 = "";
		String nikeaddress21 = "";
		String nikemessage1 = "";

		String originalFileName = "";

		String uploadPath = request.getSession().getServletContext().getRealPath("Nike_cart_image");
		// String uploadPath = request.getRealPath("/image/");
		System.out.println(uploadPath);

		int maxSize = 1024 * 1024 * 10;

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, maxSize, "UTF-8",
					new DefaultFileRenamePolicy());
			
			email1 = multi.getParameter("email");
			itemnum1 = multi.getParameter("itemnum");
			title1 = multi.getParameter("title");
			price1 = Integer.parseInt(multi.getParameter("price"));
			board1 = multi.getParameter("board");
			num1 = Integer.parseInt(multi.getParameter("num"));
			pic1 = multi.getParameter("pic1");
			pic2 = multi.getParameter("pic2");
			content1 = multi.getParameter("content");
			category1 = multi.getParameter("category");
			
			originalFileName = multi.getOriginalFileName("pic");
			
			nikename1 = multi.getParameter("nikename");
			nikephone1 = multi.getParameter("nikephone");
			nikeaddress1 = multi.getParameter("nikeaddress");
			nikeaddress21 = multi.getParameter("nikeaddress2");
			nikemessage1 = multi.getParameter("nikemessage");

			System.out.println(email1 + " " + title1 + " " + price1 + " " + num1 + " " + board1 + " "
					+ pic2 + " " + content1 + " " + category1 + " 오리지날 파일 경로 : " + originalFileName + " " +
					nikename1 + " " + nikephone1 + " " + nikeaddress1 + " " + nikeaddress21 + " " + nikemessage1 + " 배고파 ");
			
			request.setAttribute("email1", email1);
			request.setAttribute("itemnum1", itemnum1);
			request.setAttribute("title1", title1);
			request.setAttribute("price1", price1);
			request.setAttribute("board1", board1);
			request.setAttribute("num1", num1);
			request.setAttribute("pic1", pic1);
			request.setAttribute("pic2", pic2);
			request.setAttribute("content1", content1);
			request.setAttribute("category1", category1);
			
			request.setAttribute("nikename1", nikename1);
			request.setAttribute("nikephone1", nikephone1);
			request.setAttribute("nikeaddress1", nikeaddress1);
			request.setAttribute("nikeaddress21", nikeaddress21);
			request.setAttribute("nikemessage1", nikemessage1);
			
			
			forward.setRedirect(false);
			forward.setPath("./NikeMain/Nike_Order_2.jsp");
			return forward;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

}
