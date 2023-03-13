package co.develhope.interceptorsmiddleware1.configurations;

import co.develhope.interceptorsmiddleware1.interceptors.APILoggingInterceptor;
import co.develhope.interceptorsmiddleware1.interceptors.LegacyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*Questa è una classe di configurazione di Spring MVC che definisce l'utilizzo di due interceptor,
APILoggingInterceptor e LegacyInterceptor, per gestire le richieste HTTP in ingresso.

In particolare, la classe implementa l'interfaccia WebMvcConfigurer di Spring, che fornisce i metodi per personalizzare
la configurazione dell'applicazione Spring MVC.

Nel metodo addInterceptors, la classe registra i due interceptor sul InterceptorRegistry di Spring.
In particolare, registriamo l'interceptor APILoggingInterceptor utilizzando il metodo addInterceptor.
Questo significa che l'interceptor sarà utilizzato per tutte le richieste HTTP in ingresso.

Inoltre, registriamo l'interceptor LegacyInterceptor utilizzando il metodo addInterceptor e specificando l'endpoint legacy
come pattern di matching tramite il metodo addPathPatterns.
Ciò significa che l'interceptor LegacyInterceptor verrà utilizzato solo per le richieste HTTP che iniziano con la stringa "/legacy".
Questo interceptor è stato progettato per bloccare le chiamate all'endpoint legacy e restituire una risposta con lo stato HTTP "Gone" (410),
come spiegato nel "READ ME" dell'esercizio.

Inoltre, la classe utilizza l'annotazione @Autowired per iniettare le istanze degli interceptor APILoggingInterceptor e LegacyInterceptor,
che sono state definite altrove come componenti di Spring.
In questo modo, possiamo configurare gli interceptor in modo centralizzato e riutilizzarli in diverse parti dell'applicazione
senza doverli definire ogni volta.*/

@Component
public class SpringMVCConfiguration implements WebMvcConfigurer {

    @Autowired
    private APILoggingInterceptor apiLoggingInterceptor;

    @Autowired
    private LegacyInterceptor legacyInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiLoggingInterceptor);
        registry.addInterceptor(legacyInterceptor).addPathPatterns("/legacy");
    }
}
/*l'ordine nel quale si aggiungono gli interceptor al InterceptorRegistry è molto importante,
perché determina l'ordine in cui gli interceptor vengono eseguiti durante l'elaborazione delle richieste.

In particolare, gli interceptor vengono eseguiti nell'ordine in cui sono stati aggiunti al InterceptorRegistry.
Questo significa che l'interceptor aggiunto per primo verrà eseguito per primo, seguito dall'interceptor successivo e così via.

Ciò significa che l'interceptor apiLoggingInterceptor verrà eseguito per primo per tutte le richieste in ingresso,
mentre l'interceptor legacyInterceptor verrà eseguito solo per le richieste che corrispondono al pattern "/legacy".


*/