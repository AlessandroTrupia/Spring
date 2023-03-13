package co.develhope.interceptorsmiddleware1.interceptors;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LegacyInterceptor implements HandlerInterceptor {
/*Nel metodo preHandle di questo interceptor, il controllo per verificare se la richiesta è rivolta all'endpoint
legacy è effettuato utilizzando il metodo getRequestURL() dell'oggetto HttpServletRequest. In particolare, viene
controllato se l'URL della richiesta contiene la stringa "/legacy" utilizzando il metodo contains.

Se la richiesta è rivolta all'endpoint legacy, viene impostato lo stato della risposta a HttpServletResponse.SC_GONE,
che corrisponde al codice di stato HTTP 410 "Gone".
Inoltre, viene ritornato false per indicare che la richiesta non deve essere gestita dal controller principale dell'applicazione.

Se la richiesta non è rivolta all'endpoint legacy, invece, viene ritornato true per consentire il passaggio della richiesta
al controller principale dell'applicazione.*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getRequestURL().toString().contains("/legacy")){
            response.setStatus(HttpServletResponse.SC_GONE);
            return false;
        }
        return true;
    }

}