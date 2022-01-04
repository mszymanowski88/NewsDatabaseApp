package com.example.newsdatabaseapp.controller;

import com.example.newsdatabaseapp.api.Response;
import com.example.newsdatabaseapp.dao.NewsDaoImpl;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@Controller
public class NewsController {


NewsDaoImpl newsDaoImpl;
Response response = new Response();




@Autowired
    public NewsController(NewsDaoImpl newsDaoImpl) {

        this.newsDaoImpl = newsDaoImpl;

    }


//    @PostMapping("/delete")
//    public String removeDb() {
//        newsDaoImpl.deleteDatabase();
//        return "redirect:/news";
//
//
//    }


    public void deleteDatabase()
    {
        newsDaoImpl.deleteDatabase();



    }

    @GetMapping("/start")
    public String showResultFromInput( Model model) throws UnirestException, ParseException {
//    String s = "dollar";
//        model.addAttribute( "news",new Response());
//        model.addAttribute( "news",new Article());
//        model.addAttribute( "inputNews",new Article());
        model.addAttribute("news",newsDaoImpl.showListOfNews() );
        model.addAttribute("user", newsDaoImpl.findAll());



        return "start";
    }
//
//    @RequestMapping(value = "/start", method = RequestMethod.GET)
//    public String index(Model md){
//        md.addAttribute("user", newsDaoImpl.findAll());
//
//        return "redirect:/start";
//    }
//    @PostMapping("/add")
//    public String addCar(@ModelAttribute String inputFromUser) throws UnirestException, ParseException {
//
//
////       newsDaoImpl.saveNews1(inputFromUser);
////        newsDaoImpl.guardianSaveNews(inputFromUser);
////     response.userQueryGuardian(inputFromUser);
//     response.userQueryGuardian(inputFromUser);
//        System.out.println("User input" + inputFromUser);
//        return "redirect:/start";
//
//    }

//    @PostMapping("/add")
//    public String addCar(@ModelAttribute Response response) throws UnirestException, ParseException {
//
//
////       newsDaoImpl.saveNews1(inputFromUser);
////        newsDaoImpl.guardianSaveNews(inputFromUser);
////     response.userQueryGuardian(inputFromUser);
//
//        response.userQueryGuardian("Poland");
//        System.out.println("User input" + response);
//        return "redirect:/start";
//
//    }


    @PostMapping("/add")
    public String addCar(@RequestParam(value = "participant", required = false) String participant) throws UnirestException, ParseException {


       newsDaoImpl.saveNews1(participant);
//        newsDaoImpl.guardianSaveNews(inputFromUser);
newsDaoImpl.userQuery(participant);

        response.userQueryGuardian(participant);
        System.out.println("User input" + participant);
        return "redirect:/start";

    }

//    @RequestMapping(value="add/doDelete", method = RequestMethod.POST)
//    public String deleteUser (@RequestParam String input) throws UnirestException, ParseException {
//       newsDaoImpl.userQuery(input);
//        return "redirect:/start";
//    }

    @PostMapping("/create")
    public String createNewDb() throws UnirestException, ParseException {

        System.out.println("Create zrobione");
        newsDaoImpl.initDB();
        return "redirect:/start";

    }

    @PostMapping("/delete")
    public String removeDb() {
        newsDaoImpl.deleteDatabase();
        return "redirect:/error";


    }
//    @GetMapping("/news")
//    public String getNews(Model model)  {
//
//        model.addAttribute("news",new Article());
//
//        return "news";
//
//    }


//@GetMapping("/news")
//public String getNews(Model model) throws UnirestException, ParseException {
//
//    model.addAttribute("news",newsDaoImpl.newsSection1());
//
//    return "news";
//
//}
//
//    @GetMapping("/news")
//    public String getNews(Model model) throws UnirestException, ParseException {
//
//        model.addAttribute("news",newsDaoImpl.showListOfNews());
////        model.addAttribute("delete" ,deleteDatabase());
//
//        return "news";
//
//    }

//    @DeleteMapping("/news")
//    public String deleteDatabase(Model model) throws UnirestException, ParseException {
//
//
//        model.addAttribute("delete" ,deleteDatabase());
//
//        return "news";
//
//    }



//    @RequestMapping(value = "start", method = RequestMethod.GET)
//    public String showStudentBySurname(@RequestParam(value = "input", required = false) String input, Model model) throws UnirestException, ParseException {
//        model.addAttribute("search", newsDaoImpl.userQuery(input));
////        model.addAttribute("news", newsDaoImpl.showListOfNews());
//        return "start";
//    }



//@PostMapping("/search")
//    public String searchForNews (@ModelAttribute String input, Model model) throws UnirestException, ParseException {
//
////    newsDaoImpl.userFrontendInput(input);
////    newsDaoImpl.saveNews(input);
//    newsDaoImpl.showListOfNews();
//
//    return "redirect:/news";

//}

//    @PostMapping("/news/{input}")
//    public String getWeatherForCity(@PathVariable String userInput, Model model) throws UnirestException, ParseException {
//
////    model.addAttribute("news",new Article());
//// newsDaoImpl.saveNews(userInput);
////    model.addAttribute("news1", newsDaoImpl.userInput(new Article().getInput()));
//
//
//        return "news/{input}";
//    }


//

//
//    @PostMapping("/start")
//    public String getCityWeatherByInput(@ModelAttribute Article article, Model model) throws HttpClientErrorException, UnirestException, ParseException {
//        String userInput = article.getInput();
//
//
//        model.addAttribute("news1", newsDaoImpl.userInput(article.getInput()));
//
//        return "news";
//
//
//    }
//
//@PostMapping("/start")
//public String getUserInput(@ModelAttribute String input, Model model) throws UnirestException, ParseException {
//
//
//model.addAttribute("news",newsDaoImpl.userQuery(input));
//
//
//return  "news";
//}

//    @GetMapping("/start")
//    public String getWeatherForCity(@PathVariable String userInput,Model model) throws UnirestException, ParseException {
//
//    model.addAttribute("news",newsDaoImpl.userQuery(userInput));
//
//        return "start";
//    }

//    @PostMapping("/start")
//    public String addCar(@ModelAttribute String input, BindingResult bindingResult) throws UnirestException, ParseException {
//
//
//
//    newsDaoImpl.saveNews(input);
//
//        return "redirect:/news";
//
//    }

//    @PostMapping("/start")
//    public String getInputFromUser(@RequestParam String input) throws UnirestException, ParseException {
//
//
//
//        newsDaoImpl.saveNews(input);
//
//        return "redirect:/news";
//
//    }

//    @PostMapping("/search")
//    public String getInputFromUser(@ModelAttribute String input, Model model) throws UnirestException, ParseException {
//
//
//
//    model.addAttribute("listOfNews",newsDaoImpl.userQuery(input));
//
//        return "redirect:/news";
//
//    }


//    @PostMapping("/start/{input}")
//    public String pidUserSubmit(@PathVariable(value = "input") String myInput,  Model model) throws UnirestException, ParseException {
//       model.addAttribute("userInput",newsDaoImpl.userInput(myInput));
//        return "start";
//    }

//    @GetMapping("/start")
//    public String  showInputFromUser(Model model) throws UnirestException, ParseException {
//
//model.addAttribute("input", new Response());
//        return "start";
//
//    }
//
//    @GetMapping("/start/{input}")
//    public String showResultFromInput(@PathVariable String input, Model model) throws UnirestException, ParseException {
//        model.addAttribute("listOfCarsByYear", newsDaoImpl.userInput(input));
//
//
//        return "news";
//    }



//    @GetMapping("/start")
//    public String  showInputFromUser() throws UnirestException, ParseException {
//
//
//
//
//        return "start";
//
//    }


//
//    @GetMapping("/carsbybrand/{brand}")
//    public String showbyBrand(@PathVariable String brand, Model model) {
//        model.addAttribute("listOfCarsByBrand", carDaoImpl.getCarFromListByBrand(brand));
//
//
//        return "carsbybrand";
//    }


}
