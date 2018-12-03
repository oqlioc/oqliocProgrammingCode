package Nike.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import NikeAddToCartDB.NikeAddToCartDAO;
import NikeAdminDB.NikeAdminDAO;
import NikeAdminDB.NikeAdminDTO;

public class NikeCartOrderForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();

		String url1 = "";
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

		String originalFileName = "";

		String uploadPath = request.getSession().getServletContext().getRealPath("Nike_cart_image");
		// String uploadPath = request.getRealPath("/image/");
		System.out.println(uploadPath);

		int maxSize = 1024 * 1024 * 10;

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, maxSize, "UTF-8",
					new DefaultFileRenamePolicy());

			url1 = multi.getParameter("url");
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

			System.out.println(email1 + " " + title1 + " " + price1 + " " + num1 + " " + board1 + " " + pic1 + " "
					+ pic2 + " " + content1 + " " + category1 + " 오리지날 파일 경로 : " + originalFileName);
			
			NikeAdminDAO dao = new NikeAdminDAO();
			NikeAdminDTO dto = dao.detail(itemnum1);

			request.setAttribute("order_list_1", dto);
			
			forward.setRedirect(false);
			forward.setPath("./NikeMain/Nike_Order.jsp");
			return forward;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

}
