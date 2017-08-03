package pl.lmnt.DocsDrive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.lmnt.DocsDrive.service.SearchEngine;

/**
 * Created by luke on 30.07.2017.
 */
@RequestMapping("/")
@Controller
public class MainController {

    @Autowired
    SearchEngine searchEngineImpl;

    @GetMapping
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("list", searchEngineImpl.findAll());
        return view;
    }

}
