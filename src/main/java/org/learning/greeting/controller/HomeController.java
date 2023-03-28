package org.learning.greeting.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.stream.Collectors;
import org.learning.greeting.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

  @GetMapping
  public String home(Model model, @RequestParam(name = "username", required = false) String nameQueryString, @RequestParam(required = false) Integer id){
    String todayFormat = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
    model.addAttribute("today", todayFormat);
    model.addAttribute("user", nameQueryString);
    return "home";
  }


}
