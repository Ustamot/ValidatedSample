package com.ustamot.sample.validated.demo.controller;

import com.ustamot.sample.validated.demo.entity.PersonDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HelloController {
    @RequestMapping(name = "/", method = { RequestMethod.GET })
    public String get() {
        return "index";
    }

    @RequestMapping(name = "/", method = { RequestMethod.POST })
    public String post(@ModelAttribute @Validated PersonDto form, BindingResult bindingResult, Model model) {
        String msg = "入力値に誤りがあります。";
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError err : errors) {
                System.out.println(err.getField());
                System.out.println(err.getDefaultMessage());
                System.out.println(err.getCode());
            }
            for (ObjectError error : bindingResult.getGlobalErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            model.addAttribute("msg", msg);
        }
        model.addAttribute("person", form);
        return "index";
    }

//    @RequestMapping(name = "/", method = { RequestMethod.POST })
//    public String post(@RequestParam(name="name") @Validated  String name1, @RequestParam(name="age") @Validated  String age1, Model model) {
//        PersonDto form = new PersonDto();
//        form.setName(name1);
//        form.setAge(age1);
//        model.addAttribute("person", form);
//        return "index";
//    }
}