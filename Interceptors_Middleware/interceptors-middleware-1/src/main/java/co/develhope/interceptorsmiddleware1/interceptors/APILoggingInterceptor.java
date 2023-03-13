package co.develhope.interceptorsmiddleware1.interceptors;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*Questo è un codice Java che definisce un interceptor per la gestione delle richieste HTTP in un'applicazione web.

In particolare, questo interceptor si occupa di stampare l'User-Agent del client che ha effettuato la richiesta.
L'User-Agent è una stringa che identifica il tipo di browser o applicazione che il client sta utilizzando per effettuare la richiesta.

La classe implementa l'interfaccia HandlerInterceptor che permette di intercettare e gestire le richieste HTTP in ingresso.
Il metodo "preHandle" viene eseguito prima che la richiesta venga gestita dal controller principale dell'applicazione.
Se il metodo ritorna "true", la richiesta verrà gestita normalmente, altrimenti verrà interrotta.

In questo caso, il metodo "preHandle" stampa sulla console l'User-Agent della richiesta,
che viene recuperato tramite l'oggetto HttpServletRequest passato come parametro.
Infine, il metodo ritorna "true" per indicare che la richiesta deve essere gestita normalmente.*/
@Component
public class APILoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getHeader("User-Agent"));
        return true;
    }

}