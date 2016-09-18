package hello1;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hello1.myUser;
import hello1.myUserDAO;
import hello1.JdbcmyUserDAO;

@Controller
public class HelloController {

    @Autowired
    private JdbcmyUserDAO jdbcmyUserDAO;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index() {
        return "hello";
    }

    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String hello(ModelMap model) {
        model.addAttribute("msg", "Spring mvc");
        return "hello";
    }

    @RequestMapping(value="/tmp", method=RequestMethod.GET)
    public String tmp(Model model) {
        model.addAttribute("name", "Spring mvc");
        return "tmp";
    }

    @RequestMapping(value="/comments", method=RequestMethod.GET)
    public String comments(Model model) {
        myUser u = jdbcmyUserDAO.findById(1);
        Vector comments = new Vector(10,1);
        comments.addElement("hello");
        comments.addElement("hello1");
        comments.addElement("hello2");
        comments.addElement(u.Name);
        model.addAttribute("msg", "jstl forEach");
        model.addAttribute("comments", comments);
        return "comments";
    }
}
