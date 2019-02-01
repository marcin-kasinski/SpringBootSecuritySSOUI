package org.baeldung.config;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

//----------------------------------- 2.0.1 -----------------------------------	
import brave.Span;
import brave.Tracer;
//----------------------------------- 2.0.1 -----------------------------------	

//----------------------------------- 1.5.10 -----------------------------------
//import org.springframework.cloud.sleuth.Span;
//import org.springframework.cloud.sleuth.Tracer;
//----------------------------------- 1.5.10 -----------------------------------

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

//import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
class WebController {

	@Autowired
	Environment env;

	 private static Logger log = LoggerFactory.getLogger(WebController.class);

    @GetMapping("/")
    public String welcomeVIEW(Model model) {

    	log.info("IN welcomeVIEW executed");
/*
    	List<Greeting> allGreetings = new ArrayList();
    	
    	Greeting greeting0 = new Greeting();
    	greeting0.setContent("Content0");
    	allGreetings.add(greeting0);

    	Greeting greeting1 = new Greeting();
    	greeting1.setContent("Content1");

    	allGreetings.add(greeting1);
    	
    	model.addAttribute("map",allGreetings);
*/

    	System.out.println("END");
//    	long duration = System.nanoTime() - startTime;

        return "index";
    }

    @GetMapping("/securedPage")
    public String securedPage(Model model) {

    	log.info("IN securedPage executed");

    	System.out.println("END");

        return "securedPage";
    }

    @Secured("ROLE_DEVELOPERS")
    @GetMapping("/onlyfordevelopers")
    public String onlyfordevelopers(Model model) {

    	log.info("IN onlyfordevelopers executed");

    	System.out.println("END");

        return "onlyfordevelopers";
    }
    @GetMapping("/accessdenied")
    public String accessdenied(Model model) {

    	log.info("IN accessdenied executed");

    	System.out.println("END");

        return "accessdenied";
    }
    
    /*

    <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" /> 


 */
/*
//    @RequestMapping(value="/logout", method = RequestMethod.GET)
    @GetMapping("/logoutmanually")
//	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
    	public String logoutPage (HttpServletRequest request, HttpServletResponse response, SessionStatus session) {
    	
    	
    	log.info("IN logout executed");
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	    if (auth != null){    
//	    	log.info("------------- "+auth);
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    	log.info("--------------------IN logout executed");
//	    }
	    SecurityContextHolder.getContext().setAuthentication(null);
    	log.info("-------------------- invalidated");

	    session.setComplete();
	    request.getSession().invalidate();
    	log.info("-------------------- invalidated");
	    
	    return "redirect:/login?logout";
	}

*/

    
    /*
	@RequestMapping("/")
	public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
*/
/*	
	// inject via application.properties
		@Value("${welcome.message:test}")
		private String message = "Hello World";


	@RequestMapping("/x")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "greeting";
	}
*/
}