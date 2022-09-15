package com.sp.studentinfo.controller;

import com.sp.studentinfo.entity.StudentTableEntity;
import com.sp.studentinfo.repository.StudentTableEntityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class StudentController {
    StudentTableEntityRepository studentTableEntityRepository;

    public StudentController(StudentTableEntityRepository studentTableEntityRepository) {
        this.studentTableEntityRepository = studentTableEntityRepository;
    }

    @GetMapping("/")
    public String listStudents(Model model){
        model.addAttribute("students",studentTableEntityRepository.findAll());
        return "students";

    }

    @GetMapping("/enter-student-info")
    public String enterStudentsInfo(Model model){
        model.addAttribute("student", new StudentTableEntity());
        return "students-form";

    }
    @PostMapping("/enter-student-info")
    public String enterStudentsInfo(Model model, @ModelAttribute StudentTableEntity student){
        studentTableEntityRepository.save(student);
        return "redirect:/";

    }
    @GetMapping("/edit/{id}")
    public String editStudentsInfo(Model model, @PathVariable String id){
        model.addAttribute("student", studentTableEntityRepository.findById(Integer.parseInt(id)).get());
        return "students-form-edit";

    }
    @PostMapping("/edit-student-info")
    public String updateStudentsInfo(Model model, @ModelAttribute StudentTableEntity student){
        studentTableEntityRepository.save(student);
        return "redirect:/";

    }
    @GetMapping("/delete-student/{id}")
    public String deleteStudentsInfo(Model model, @PathVariable String id){
        StudentTableEntity student = studentTableEntityRepository.findById(Integer.parseInt(id)).get();
        studentTableEntityRepository.delete(student);
        return "redirect:/";

    }
    @PostMapping("/delete/{id}")
    public String deleteStudent(Model model, @PathVariable("id") String id, StudentTableEntity student) {
        Optional<StudentTableEntity> studentRec = studentTableEntityRepository.findById(Integer.parseInt(id));
        if(studentRec.isPresent()) {
            studentTableEntityRepository.delete(studentRec.get());
        }
        return "redirect:/";

    }

    @GetMapping("/student/{id}")
    public String getStudent(Model model, @PathVariable String id){
        model.addAttribute("student", studentTableEntityRepository.findById(Integer.parseInt(id)).get());
        return "student";
    }
}
