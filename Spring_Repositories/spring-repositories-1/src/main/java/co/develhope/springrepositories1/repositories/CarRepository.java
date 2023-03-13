package co.develhope.springrepositories1.repositories;

import co.develhope.springrepositories1.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long> {
}
/*@RepositoryRestResource è un'annotazione in Spring Data Rest che consente di esporre un repository JPA come un servizio REST.
Questo significa che i dati gestiti dal repository possono essere facilmente recuperati e modificati tramite chiamate HTTP,
come ad esempio GET, POST, PUT e DELETE.
L'annotazione @RepositoryRestResource viene utilizzata insieme ad un repository JPA e consente di esporre i dati gestiti
dal repository tramite un servizio REST senza dover scrivere manualmente il codice per la gestione delle richieste HTTP.
In questo modo è possibile semplificare e velocizzare lo sviluppo di applicazioni che devono gestire dati tramite un servizio REST.*/