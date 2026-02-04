package Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ejemploController {
    @GetMapping("/PruebaSpring")
    public String holaMundo(){return "Hola Mundo";}
}
