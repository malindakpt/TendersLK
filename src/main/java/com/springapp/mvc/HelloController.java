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
		model.addAttribute("message", "Hello world!");
		return "ViewVehicle";
	}
}

@Controller
@RequestMapping("/1")
class HelloController2 {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "AddVehicle";
	}
}

@Controller
@RequestMapping("/2")
class HelloController3 {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "CreateAd";
	}
}

@Controller
@RequestMapping("/3")
class HelloController4 {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "SearchResult";
	}
}

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
			//model.addAttribute("message", "Hello world!");
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