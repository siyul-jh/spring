package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dto.MailDTO;
import poly.service.IMailService;
import poly.util.CmmUtil;

@Controller
public class MailController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "MailService")
	private IMailService mailService;
	
	@RequestMapping(value = "mail/sendMail", method = RequestMethod.POST)
	public String sendMail(HttpServletRequest request, HttpServletResponse reponse, ModelMap model) { 
		log.info(this.getClass().getCanonicalName() +  "mail.sendMail start!");
		
		String toMail = CmmUtil.nvl(request.getParameter("toMail"));
		String title = CmmUtil.nvl(request.getParameter("title"));
		String contents = CmmUtil.nvl(request.getParameter("contents"));
		
		log.info("sendMail.toMail : " + toMail);
		log.info("sendMail.title : " + title);
		log.info("sendMail.contents : " + contents);

		
		MailDTO pDTO =new MailDTO();
		
		pDTO.setToMail(toMail);
		pDTO.setTitle(title);
		pDTO.setContents(contents);
		
		int res = mailService.doSendMail(pDTO);
		
		if(res == 1) { 
			log.info(this.getClass().getName() + "mail.sendMail success !!!");
		} else { 
			log.info(this.getClass().getName() + "mail.sendMail fail !!!");

		}
		
		model.addAttribute("res", String.valueOf(res));
		
		log.info(this.getClass().getName() + "mail.sendMail end !");
		
		return "/mail/sendMailResult";
	}
	
	@RequestMapping(value="mail/mailForm")
	public String mailForm() { 
		log.info(this.getClass().getName() + " mail.mailForm start !");
		log.info(this.getClass().getName() + " mail.mailForm end !");
		return "mail/mailForm";
	}
	

}
