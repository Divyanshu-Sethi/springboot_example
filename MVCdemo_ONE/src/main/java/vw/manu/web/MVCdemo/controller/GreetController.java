package vw.manu.web.MVCdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/webcontrol")
@Controller  //@RestController = @Controller + @ResponseBody
public class GreetController {
	
	@GetMapping("/greet")
	public String greetAll() {
		return "greetall";
	}
	
	@GetMapping("/greet/{msg}")
	public String greetAll(@PathVariable String msg, ModelMap map) {
		map.addAttribute("message",msg);
		return "greet";
	}
	
	@ResponseBody
	@GetMapping("/greet1/{name}")
    public String greetAll1(@PathVariable String name) {
		return "Hello "+name;
	}
}
