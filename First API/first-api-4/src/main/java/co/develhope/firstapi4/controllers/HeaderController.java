package co.develhope.firstapi4.controllers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**

 The {@code HeaderController} class is a Spring MVC controller that handles requests related to headers.
 */
@RestController
@RequestMapping("/headers")
public class HeaderController {
    /**

     Returns the host name and port number in the HttpHeaders object as a string in response to a GET request to "/getHeaders".
     @param headers The HttpHeaders object that contains the host information.
     @return A ResponseEntity object containing the host name and port number.
     */
    @GetMapping("/gethostinfo")
    public ResponseEntity<String> getHostInfo(@RequestHeader HttpHeaders headers){
        return ResponseEntity.ok(
                "Hostname: " + headers.getHost().getHostName()
                + "\n port: " + headers.getHost().getPort());
    }
}
/*Il codice eseguito è una classe Spring MVC che gestisce richieste relative agli header.
La classe ha un metodo che restituisce il nome dell'host e il numero di porta come una stringa in risposta ad una richiesta GET a "/getHeaders".
Il metodo prende un oggetto HttpHeaders come parametro che contiene le informazioni dell'host.
La risposta viene restituita come un oggetto ResponseEntity che contiene la stringa con il nome dell'host e il numero di porta.*/