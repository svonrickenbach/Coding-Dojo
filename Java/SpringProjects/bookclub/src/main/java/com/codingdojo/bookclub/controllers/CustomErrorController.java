package com.codingdojo.bookclub.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {

   private static final String ERROR_PATH = "/error";

   @GetMapping(ERROR_PATH)
   public String handleError(HttpServletRequest request) {
       // logic to handle error and return custom error page
       return "redirect:/books";
   }
}