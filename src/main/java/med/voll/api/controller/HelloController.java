package med.voll.api.controller; // Declara o pacote da classe

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// indica que esta classe é um controlador REST do Spring Boot
@RestController
// Define o caminho base para as requisições deste controller
@RequestMapping("/hello")

public class HelloController {

    // Mapeia este metodo para requisições HTTP GET no caminho "/hello"
    @GetMapping
    public String olaMundo() {
        // Retorna uma string como resposta da requisição
        return "Hello world Spring!";
    }
}