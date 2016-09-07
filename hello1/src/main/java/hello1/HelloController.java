package hello1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
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
}
