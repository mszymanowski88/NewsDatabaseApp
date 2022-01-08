package com.example.newsdatabaseapp.controller;

import com.example.newsdatabaseapp.dao.NewsDaoImpl;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

@Controller
public class NewsController {


    private NewsDaoImpl newsDaoImpl;


    @Autowired
    public NewsController(NewsDaoImpl newsDaoImpl) {

        this.newsDaoImpl = newsDaoImpl;

    }


    @GetMapping("/start")
    public String showResultFromInput(Model model) {


        model.addAttribute("news", newsDaoImpl.findAll());


        return "start";
    }


    @PostMapping("/add")
    public String addCar(@RequestParam(value = "input", required = false) String input) throws UnirestException, ParseException {

        newsDaoImpl.saveNews(input);

        return "redirect:/start";

    }


    @PostMapping("/create")
    public String createNewDb() {

        newsDaoImpl.initDB();

        return "redirect:/start";

    }

    @PostMapping("/delete")
    public String removeDb() {
        newsDaoImpl.deleteDatabase();

        return "redirect:/error";


    }
}
