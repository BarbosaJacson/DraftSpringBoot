package com.example.SpringWebExercise.controller; // Package updated for the new project name

import com.example.SpringWebExercise.model.Person; // Import the Person class from the correct package
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; // Import this class for validation
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid; // Import this annotation for validation

import java.util.ArrayList;
import java.util.List;

@Controller // Indicates that this class is a Spring MVC controller
public class HomeController {

    /**
     * Maps GET requests to the root URL ("/").
     * Displays the home page with a message and a list of objectives.
     * @param model The Model object is used to pass data from the controller to the view (template).
     * @return The name of the template (without the .html extension) that should be rendered.
     */
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tituloPagina", "Welcome to My Dynamic Website!");
        model.addAttribute("mensagem", "This is your first web project with Spring Boot and Thymeleaf!");

        List<String> itens = new ArrayList<>();
        itens.add("Item 1: Learn Spring Boot");
        itens.add("Item 2: Create dynamic web pages");
        itens.add("Item 3: Integrate with database");
        itens.add("Item 4: Deploy the application");
        model.addAttribute("listaDeItens", itens);

        return "index";
    }

    /**
     * NEW METHOD: Maps GET requests to the "/form" URL.
     * Displays the person registration form.
     * @param model The Model object is used to pass a new empty Person object to the form.
     * @return The name of the "form.html" template.
     */
    @GetMapping("/form") // Changed URL from /formulario to /form
    public String displayForm(Model model) { // Changed method name to English
        model.addAttribute("person", new Person()); // Adds an empty Person object to the model (attribute name also changed to 'person')
        return "form"; // Returns the form.html template (changed to 'form')
    }

    /**
     * NEW METHOD: Maps POST requests to the "/save" URL.
     * Processes the data submitted by the form and applies validation.
     * @param person The Person object is automatically populated with form data
     * thanks to the @ModelAttribute annotation.
     * @param result Contains the validation results.
     * @param model The Model object is used to pass the person data to the result page.
     * @return The name of the "result.html" template if valid, or "form.html" if there are errors.
     */
    @PostMapping("/save") // Changed URL from /salvar to /save
    public String saveForm(@ModelAttribute @Valid Person person, BindingResult result, Model model) { // Changed method name and parameter name to English
        // Checks if there are validation errors in the 'result' object
        if (result.hasErrors()) {
            // If there are errors, returns to the same form so that the errors can be displayed.
            // The 'person' object (with the data the user entered) and the errors
            // will automatically be in the model.
            return "form"; // Returns the form.html template
        }

        // If there are no validation errors, continues processing (for now, just displays).
        model.addAttribute("person", person); // Adds the person to the model for display (attribute name also changed to 'person')
        return "result"; // Returns the result.html template (changed to 'result')
    }
}

