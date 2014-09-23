package com.kasun.web;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kasun.run.Run;

@Controller
@RequestMapping("/*")
public class MainController {

	private static final Logger log = LoggerFactory
			.getLogger(MainController.class);

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "සිංහල පරිවර්තකය");
		return "hello";
	}

	@RequestMapping(value = "/conv", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
	public @ResponseBody
	String add(@RequestParam(value = "input", required = true) String input) throws UnsupportedEncodingException {
		String result = Run.getTranslation(input);
		log.info(result);
		return result;
	}
}
