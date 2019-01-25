package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController 
{
 @RequestMapping ("/login")
 public String showLogin(Model m) 
 {
  m.addAttribute("pageinfo","Login");
  return "login";
 } 
 
 @RequestMapping ("/register")
 public String showRegister(Model m) 
 {
  m.addAttribute("pageinfo","Register");
  return "register";
 } 
 
 @RequestMapping ("/contactus")
 public String showContactUs(Model m) 
 {
  m.addAttribute("pageinfo","ContactUs");
  return "contactus";
 } 
 
 @RequestMapping ("/aboutus")
 public String showAboutUs(Model m) 
 {
  m.addAttribute("pageinfo","AboutUs");
  return "aboutus";
 } 
 
 @RequestMapping ("/home")
 public String showHome(Model m) 
 {
  m.addAttribute("pageinfo","Home"); 
  return "home";
 } 
 
}
