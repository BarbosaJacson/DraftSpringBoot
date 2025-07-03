package com.example.SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Indica que esta classe é um controlador Spring MVC
public class HomeController {

    /**
     * Mapeia requisições GET para a URL raiz ("/")
     * @param model O objeto Model é usado para passar dados do controlador para a view (template).
     * @return O nome do template (sem a extensão .html) que deve ser renderizado.
     */
    @GetMapping("/")
    public String home(Model model) {
        // Adiciona um atributo "mensagem" ao modelo.
        // Este atributo estará disponível no seu template HTML.
        model.addAttribute("mensagem", "Welcome to your first web project with Spring Boot and Thymeleaf!");
        // Retorna o nome do template HTML a ser renderizado.
        // O Spring Boot procurará por "index.html" em src/main/resources/templates/
        return "index";
    }
}
