package hello.spring.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hello.spring.bit.dto.UserDTO;
import hello.spring.bit.service.HomeService;

@Controller
public class HomeController {

	@Autowired
	HomeService homeService; // DI

	// [���� ������] �α��� Ȩ ������
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "login/home";
		
	}

	// �α��� Ȩ ���������� ���̵�� ��й�ȣ�� �Է��ϰ� �α��� ��ư�� ����!
	@RequestMapping("home_login")
	public String login(UserDTO userDTO, HttpServletRequest request, Model model) {

		if (homeService.login(userDTO)) {
			System.out.println("===== HomeController >> �α��� ����! =====");
			HttpSession session = request.getSession();
			session.setAttribute("userId", userDTO.getId());
			return "login/main"; // �α��� ���� �� ���������� �����ֱ�
		} else {
			System.out.println("===== HomeController >> �α��� ����! =====");
			return "login/home"; // �α��� ���� �� �α��� Ȩ ������
		}

	}

	// [������ ��ȯ] �α��� Ȩ ���������� ȸ�����Դ���!
	@RequestMapping("join_write")
	public String join_write() {

		return "login/join";
	}

	// ȸ���������������� ȸ������ �ϷḦ ����!
	@RequestMapping("join")
	public String join(Model model, UserDTO userDTO) {
		// DB�� �� �ְ� �� ������ Ȯ���ϱ�

		System.out.println(userDTO);
		if (homeService.join(userDTO) != null) {

			System.out.println("===== HomeController >> ȸ������ ����! =====");
			return "login/home";

		} else {

			System.out.println("===== HomeController >> ȸ������ ����! =====");
			return "login/home";
		}

	}

	// [������ ��ȯ] �α׾ƿ������� �α��� Ȩ ��������!
	@RequestMapping("logout")
	public String logout() {
		return "login/home";
	}

	@RequestMapping("Memberlist")
	public String Memberlist(UserDTO userDTO, Model model) {
		List<UserDTO> list = homeService.list(userDTO);
		model.addAttribute("list", list);
		
		return "login/Member_list";
	}
	
	@RequestMapping("Member_info.lo")
	public String Member_info(@RequestParam("id") String id, Model model) {
		UserDTO info_list = homeService.info(id);
		model.addAttribute("info_list", info_list);
		
		return "login/Member_info";
	}

	@RequestMapping("Membe_delete.lo")
	public String Membe_delete(@RequestParam("id") String id, Model model) {
		homeService.delete(id);
		
		return "redirect:Memberlist";
	}
}
