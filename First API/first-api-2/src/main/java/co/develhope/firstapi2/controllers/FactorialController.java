package co.develhope.firstapi2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * La classe FactorialController è annotata con @RestController
 * che indica a Spring che questa classe gestirà le richieste HTTP
 */

@RestController
@RequestMapping("/factorial")
public class FactorialController {

    /**
     *  La richiesta GET è gestita dal metodo getFactorial che utilizza l'annotazione @GetMapping
     *  per associare l'URL /factorial/{n} alla risposta del metodo.
     *  La variabile n viene passata come parametro del metodo utilizzando l'annotazione @PathVariable.
      * @param n
     * @return result
     */
    @GetMapping("/{n}")
    public long getFactorial(@PathVariable int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    /**
     * Il metodo getFactorial calcola il fattoriale di n utilizzando un ciclo for che moltiplica result per ogni numero
     * compreso tra 1 e n. Il valore finale di result viene restituito come risposta alla richiesta.
     */
}