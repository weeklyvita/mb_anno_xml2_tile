package anno_test.controller;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import anno_test.maps.TestMappable;

@Controller
@RequestMapping("/")
public class AnnoController {
	@Autowired
	Connection con;

	@Autowired
	TestMappable testMappable;

	@Autowired
	SqlSessionFactory sqlsession;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String homePage(ModelMap m) {
		System.out.println("getListXml START!");
		m.addAttribute("message", String.format("%s, %s", testMappable.getClass(), testMappable.selectTest()));
		return "home";
	}
	@RequestMapping(value = { "/home1" }, method = RequestMethod.GET)
	public String home1Page(ModelMap m) {
		System.out.println("getListXml START!");
		m.addAttribute("message", "home1");
		return "home1";
	}

	@RequestMapping(value = { "/products" }, method = RequestMethod.GET)
	public String productsPage(ModelMap m) {
		m.addAttribute("message", testMappable.getListWhere(2));
		return "products";
	}

	@RequestMapping(value = { "/contactus" }, method = RequestMethod.GET)
	public String contactUsPage(ModelMap m) {
		m.addAttribute("message", testMappable.getListWhere(2));
		return "contactus";
	}
	
	@RequestMapping(value= {"/test"},method=RequestMethod.GET)
	public String testPage(ModelMap m) {
		m.addAttribute("message", testMappable.getList());
		return "test";
	}
	
	@RequestMapping(value= {"/t1"},method=RequestMethod.GET)
	public String t1(ModelMap m) {
		m.addAttribute("message", "양식");
		return "t";
	}
	@RequestMapping(value= {"/t2"},method=RequestMethod.GET)
	public String t2(ModelMap m) {
		m.addAttribute("message", "일식");
		return "t";
	}
	@RequestMapping(value= {"/slide"},method=RequestMethod.GET)
	public String slide(ModelMap m) {
		m.addAttribute("message", "testslide");
		return "slide";
	}
	@RequestMapping(value= {"/index"},method=RequestMethod.GET)
	public String index(ModelMap m) {
		m.addAttribute("message", "testindex");
		return "index";
	}
}