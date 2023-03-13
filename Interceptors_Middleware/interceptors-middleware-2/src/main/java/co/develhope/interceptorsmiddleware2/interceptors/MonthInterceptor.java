package co.develhope.interceptorsmiddleware2.interceptors;

import co.develhope.interceptorsmiddleware2.entities.Month;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {
/* L'interceptor ha un elenco di sei oggetti Month che vengono inizializzati in una lista statica all'avvio dell'applicazione.
* */
    public static List<Month> monthList = new ArrayList<>(Arrays.asList(
            new Month(1, "January", "Gennaio", "Januar"),
            new Month(2, "February", "Febbraio", "Februar"),
            new Month(3, "March", "Marzo", "März"),
            new Month(4, "April", "Aprile", "April"),
            new Month(5, "May", "Maggio", "Mai"),
            new Month(6, "June", "Giugno", "Juni")
    ));
/*Il metodo preHandle viene chiamato prima che la richiesta venga effettivamente gestita dal controller. Il metodo controlla
se l'header monthNumber è presente nella richiesta e se contiene un valore valido.

Se monthNumber non è presente o è vuoto, l'interceptor imposta lo stato della risposta a BAD_REQUEST e restituisce un messaggio di errore.

Se monthNumber contiene un valore valido, l'interceptor cerca il mese corrispondente nella lista degli oggetti Month.
Se il mese viene trovato, l'interceptor imposta l'oggetto Month come attributo della richiesta, in modo che possa essere
utilizzato dal controller. Se il mese non viene trovato, l'interceptor imposta un oggetto Month vuoto con i campi di testo impostati su "nope".

Infine, l'interceptor imposta lo stato della risposta a OK e restituisce true, indicando che la richiesta può essere elaborata dal controller.
*/
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberString = request.getHeader("monthNumber");
        if(monthNumberString == null || monthNumberString.isEmpty()) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.getWriter().write("Error 400 - HTTP Status Code: " + HttpStatus.BAD_REQUEST.value());
            return false;
        } else {
            Integer monthNumber = Integer.parseInt(monthNumberString);
            Optional<Month> month = monthList.stream().filter(currentMonth -> currentMonth.getMonthNumber().equals(monthNumber)).findFirst();
            if(month.isPresent()) {
                request.setAttribute("month", month.get());
            } else {
                request.setAttribute("month", new Month(0, "nope", "nope", "nope"));
            }
        }
        response.setStatus(HttpStatus.OK.value());
        return true;
    }
}