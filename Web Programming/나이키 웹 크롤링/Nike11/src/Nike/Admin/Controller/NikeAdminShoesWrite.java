package Nike.Admin.Controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import NikeAdminDB.NikeAdminDAO;

public class NikeAdminShoesWrite implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward=new ActionForward();
		
		String title1 = "";
		int price1 = 0;
		int num1 = 0;
		String pic1 = "";
		String pic2 = "";
		String content1 = "";
		String board1 = "";
		String category1 = "";
		String originalFileName = "";
		
		String uploadPath = request.getSession().getServletContext().getRealPath("Nike_image");
		//String uploadPath = request.getRealPath("/image/");
		System.out.println(uploadPath);
		
		int maxSize = 1024 * 1024 * 10;
		
		try {
			MultipartRequest multi = new MultipartRequest(request,uploadPath,maxSize,"UTF-8",new DefaultFileRenamePolicy());
			
			title1 = multi.getParameter("title");
			price1 = Integer.parseInt(multi.getParameter("price"));
			num1 = Integer.parseInt(multi.getParameter("num"));
			board1 = multi.getParameter("board");
			pic1 = multi.getFilesystemName("pic1");
			pic2 = multi.getFilesystemName("pic2");
			content1 = multi.getParameter("content");
			category1 = multi.getParameter("category");
			originalFileName=multi.getOriginalFileName("pic");
			
			System.out.println(title1+" "+price1+" "+num1+" "+board1+" "+pic1+" "+pic2+" "+content1+" "+category1+" 오리지날 파일 경로 : "+originalFileName);
			NikeAdminDAO dao = new NikeAdminDAO();
			dao.shoeswrite(title1, price1, board1, num1, pic1, pic2, content1, category1);
			
			forward.setRedirect(false);
	   		forward.setPath("./NikeAdmin/Nike_Admin_Main.jsp");
	   		return forward;
	   		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
}
