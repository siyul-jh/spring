package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import poly.service.IUserInfoService;
import poly.util.Fetch;

@Controller
public class UserInfoController {

	private Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "UserInfoService")
	private IUserInfoService userInfoService;

	@RequestMapping(value = "user/userRegForm")
	public String userRegForm() {
		return "/user/UserRegForm";
	}

	@RequestMapping(value = "user/userInsert", method = RequestMethod.POST, produces = "application/json;charset=utf8")
	@ResponseBody
	public void userInsert(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		log.info(this.getClass().getName() + ".insertUserInfo start!");

		try {
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String address = request.getParameter("address");
			System.out.println(name);
			System.out.println(age);
			System.out.println(address);
		} catch (Exception error) {
			error.printStackTrace();
		}
	}
}
