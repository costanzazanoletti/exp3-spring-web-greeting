package org.learning.greeting.controller;

import java.util.ArrayList;
import java.util.List;
import org.learning.greeting.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {

  @GetMapping
  public String students(Model model){
    List<Student> list = getStudents();
   /* String names = "";
    for(Student s : list){
      names += s.getName() + ", ";
    }

    model.addAttribute("students", names.substring(0, names.length()-2));*/
    model.addAttribute("students", list);
    return "students";
  }

  @GetMapping("/{id}")
  public String studentDetail(Model model, @PathVariable int id){
    for (Student s : getStudents()){
      if(s.getId() == id){
        model.addAttribute("student", s);
      }
    }
    return "student-detail";
  }

  private List<Student> getStudents(){
    List<Student> students = new ArrayList<>();
    students.add(new Student("Jean", 5));
    students.add(new Student("Logan", 2));
    return students;
  }

}
