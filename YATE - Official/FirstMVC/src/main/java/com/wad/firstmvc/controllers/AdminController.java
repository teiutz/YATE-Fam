package com.wad.firstmvc.controllers;

import com.wad.firstmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

  @GetMapping
  public String showAddUserForm(Model model){
    model.addAttribute("user", new User());
    return "admin";
  }
}
