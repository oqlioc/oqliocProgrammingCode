package Nike.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NikeFunctionController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	protected void NikeProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		System.out.println(command);
		
		if (command.equals("/Nike_Signup.nf")) {
			action = new NikeSignup();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Signin.nf")) {
			action = new NikeLoginBooleanAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Nike_Men_Shoes.nf")) {
			action = new NikeMenShoesList();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Men_Shoes_Running.nf")) {
			action = new NikeMenShoesRunningList();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Men_Shoes_Jordan.nf")) {
			action = new NikeMenShoesJordanList();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Men_Shoes_Soccer.nf")) {
			action = new NikeMenShoesSoccerList();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Nike_Sale_Detail.nf")) {
			action = new NikeSaleDetail();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_AddToCart.nf")) {
			action = new NikeAddToCart();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Payment.nf")) {
			action = new NikeAddToCart();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Cart_List.nf")) {
			action = new NikeCartList();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Cart_List_Remove.nf")) {
			action = new NikeCartListRemove();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Cart_Order.nf")) {
			action = new NikeCartOrderForm();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Cart_Order_2.nf")) {
			action = new NikeCartOrderForm2();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Cart_Complete.nf")) {
			action = new NikeCartOrderComplete();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Cart_Form_Order_2.nf")) {
			action = new NikeCartListOrderForm2();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/Nike_Cart_Form_Complete.nf")) {
			action = new NikeCartListOrderComplete();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

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
