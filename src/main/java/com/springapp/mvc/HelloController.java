package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		return "SearchResult";
	}
}

@Controller
@RequestMapping("/AddVehicle")
class HelloController2 {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "AddVehicle";
	}
}

@Controller
 @RequestMapping("/CreateAdView")
 class HelloController3 {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "CreateAd";
	}
}

@Controller
@RequestMapping("/CreateUserView")
class CreateUserController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "CreateUser";
	}
}
@Controller
@RequestMapping("/Notification")
class NotificationController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "Notification";
	}
}

//
//@Controller
//@RequestMapping("/ViewVehicle")
//class ViewVehicle {
//	@RequestMapping(method = RequestMethod.GET)
//	public String printWelcome(ModelMap model) {
//		model.addAttribute("message", "Hello world!");
//		return "ViewVehicle";
//	}
//}


//@Controller
//@RequestMapping("/imageDownload")
//class HelloController4 {
//	@RequestMapping(method = RequestMethod.GET)
//	public String printWelcome(ModelMap model) {
//		model.addAttribute("message", "Hello world!");
//		return "firstPage";
//	}
//}
@Controller
@RequestMapping("/4")
class HelloController5 {
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	ModelAndView printWelcomebyParameter(@RequestParam("vID") String id) {
		{
			//model.addAttribute("message", "Hello world!");jgjhgjh
			ModelAndView modelAndview = null;
			try {
				//generateException();

				modelAndview = new ModelAndView("ViewVehicle");
				//modelAndview.addObject("movie",id);
			} catch (IndexOutOfBoundsException e) {
				//modelAndView = handleException();
			}
			return modelAndview;
		}
	}
}