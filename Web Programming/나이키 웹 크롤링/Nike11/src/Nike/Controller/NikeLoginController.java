package Nike.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NikeLoginController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	protected void NikeProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/Nike.ni")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./NikeMain/Nike_Main.jsp");

		} else if (command.equals("/Nike_SigninForm.ni")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./NikeLogin/Nike_Signin.jsp");

		} else if (command.equals("/Nike_SignupForm.ni")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./NikeLogin/Nike_signup.jsp");

		} else if (command.equals("/Nike_Signup.ni")) {
			action = new NikeSignup();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Signin.ni")) {
			action = new NikeLoginBooleanAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Logout.ni")) {
			HttpSession session = request.getSession();
			session.invalidate();
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./NikeLogin/Nike_Signin.jsp");

		} else if (command.equals("/Nike_Girls.ni")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./NikeGirls/Nike_Girls.jsp");

		} else if (command.equals("/Nike_Men.ni")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./NikeMen/Nike_Men.jsp");

		} else if (command.equals("/Nike_Men_Shoes.ni")) {
			action = new NikeMenShoesList();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Men_Shoes_Running.ni")) {
			action = new NikeMenShoesRunningList();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Men_Shoes_Jordan.ni")) {
			action = new NikeMenShoesJordanList();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Men_Shoes_Soccer.ni")) {
			action = new NikeMenShoesSoccerList();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Nike_Women.ni")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./NikeWomen/Nike_Women.jsp");
		} else if (command.equals("/Nike_Boys.ni")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./NikeBoys/Nike_Boys.jsp");

		}

		if (forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NikeProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NikeProcess(request, response);
	}
}
