package com.kasun.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kasun.run.Run;

@Controller
@RequestMapping("/*")
public class MainController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "hello";

    }

    @RequestMapping(value = "/conv", method = RequestMethod.POST)
    public @ResponseBody
    String add(@RequestParam(value = "input", required = true) String input) {
        // System.out.println(input);
        String result = Run.getTranslation(input);
        System.out.println(result);
        return result;
    }

}
