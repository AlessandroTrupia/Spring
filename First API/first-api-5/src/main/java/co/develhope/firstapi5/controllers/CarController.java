package co.develhope.firstapi5.controllers;

import co.develhope.firstapi5.DTO.CarDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
/*Questo è un esempio di controller di un'applicazione Spring Boot per la gestione di richieste relative a oggetti CarDTO.

La classe CarController è un componente Spring Boot che viene annotato con le annotazioni @RestController e @RequestMapping.
La prima annotazione specifica che questa classe è un controller e gestirà le richieste HTTP in arrivo.
La seconda annotazione specifica il percorso di base per le richieste relative a questa classe.

Il metodo getCar() è annotato con l'annotazione @GetMapping che specifica che questo metodo gestirà le richieste HTTP GET
a /cars/getcar/{id}/{modelName}/{price}. Questa annotazione indica che i valori degli ID, del nome del modello e del prezzo
dell'auto verranno estratti dall'URL della richiesta e assegnati ai corrispondenti parametri del metodo getCar().
Quindi, questo metodo restituirà un nuovo oggetto CarDTO con i valori passati come parametri.

Il metodo postCar() è annotato con l'annotazione @PostMapping, che specifica che questo metodo gestirà le richieste HTTP POST a /cars/postcar.
Questo metodo prende un oggetto CarDTO come parametro annotato con l'annotazione @RequestBody, che indica che il corpo
della richiesta HTTP viene deserializzato in un oggetto CarDTO.
L'annotazione @Validated indica che la validazione delle proprietà dell'oggetto CarDTO deve essere eseguita.
Se l'oggetto CarDTO è valido, il metodo stamperà l'oggetto CarDTO sulla console e restituirà lo stato HTTP 201 CREATED come risposta alla richiesta POST.*/
@RestController
@RequestMapping("/cars")

public class CarController {

    @GetMapping("/getcar/{id}/{modelName}/{price}")
    public CarDTO getCar(@PathVariable String id, @PathVariable String modelName, @PathVariable Integer price){
        return new CarDTO(id, modelName, price);
    }
    /*http://localhost:8080/cars/getcar/IT210945/FiatPanda/100000
    * {
    "id": "IT210945",
    "modelName": "FiatPanda",
    "price": 100000.0
     }*/
    @PostMapping("/postcar")
    @ResponseBody
    public String postCar(@Validated @RequestBody CarDTO car){
        System.out.println(car);
        return HttpStatus.CREATED.toString(); //http://localhost:8080/cars/postcar/  Response: 201 CREATED
    }
}