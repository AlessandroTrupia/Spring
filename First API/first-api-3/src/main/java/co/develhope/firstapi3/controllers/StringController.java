package co.develhope.firstapi3.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Questo è un esempio di un'applicazione Spring Boot che implementa un'API per la concatenazione di due stringhe.
 * La classe StringController è il controller che gestisce le richieste HTTP all'endpoint /strings.
 */

@RestController
@RequestMapping("/strings")

public class StringController {

    /**
     *  Il metodo concatenateStrings è annotato con @GetMapping("/strings")
     *  e quindi sarà eseguito quando una richiesta GET sarà inviata a /strings.
     *  use @RequestParam to extract query parameters, form parameters, and even files from the request.
     * @param string1
     * @param string2
     * @return string1 + string2
     */
    @GetMapping
    public String concatenateStrings(@RequestParam String string1,
                                     @RequestParam(required = false) String string2) {
        if (string2 == null) {
            return string1;
        }
        return string1 + " " + string2;
    }
    /*
     * All'interno del metodo concatenateStrings, viene controllato se string2 è null.
     * Se è null, viene restituita solo la prima stringa string1.
     * Altrimenti, viene restituita la concatenazione delle due stringhe string1 + string2.
     */
}
/*
 *  http://localhost:8080/strings?string1=Still
 *  http://localhost:8080/strings?string1=Still&string2=Learning
 *  Questo metodo accetta due parametri di richiesta, string1 e string2, che sono entrambi stringhe.
 *  il parametro string2 è facoltativo e non è richiesto ogni volta.
 */
