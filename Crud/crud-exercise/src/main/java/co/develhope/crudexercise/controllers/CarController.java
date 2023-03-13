package co.develhope.crudexercise.controllers;

import co.develhope.crudexercise.entities.Car;
import co.develhope.crudexercise.repositories.CarRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    //Create
    @PostMapping("/create")
    public Car create(@RequestBody Car car){
        return carRepository.saveAndFlush(car);
    }

    //Read All
    @GetMapping("read_all")
    public List<Car>getAllCars(){

        return carRepository.findAll();
    }

    //Read one
    @GetMapping("get/{id}")
    public Car getACar(@PathVariable long id){
    return carRepository.existsById(id) ? carRepository.getById(id) : new Car();
    }

    // Update
    @PutMapping("update/{id}")
    public Car updateCar(@PathVariable long id, @RequestParam String type){
        Car car;
        if (carRepository.existsById(id)){
            car = carRepository.getById(id);
            car.setType(type);
            car = carRepository.saveAndFlush(car);
        }else{
            car = new Car();
        }
        return car;
    }

    // delete a specific car
    @DeleteMapping("delete/{id}")
    public void deleteSingle(@PathVariable long id, HttpServletResponse response){
        if (carRepository.existsById(id))
            carRepository.deleteById(id);
        else
            response.setStatus(409);
    }

    // delete all
    @DeleteMapping("delete_all")
    public void deleteAll(){
        carRepository.deleteAll();
    }
}

/*NOTA PERSONALE
Questo codice rappresenta un controller REST per un'applicazione che gestisce un'entità chiamata "Car".

Il controller utilizza il repository "CarRepository" per eseguire operazioni CRUD (create, read, update e delete) sulla entità "Car".
Le annotazioni REST utilizzate nel codice sono @RestController, @RequestMapping, @PostMapping, @GetMapping, @PutMapping e @DeleteMapping.

Le operazioni CRUD implementate sono le seguenti:

Create: l'operazione POST "/cars/post" crea un nuovo oggetto "Car" a partire da un oggetto "Car" passato come corpo della richiesta.
Il nuovo oggetto viene salvato nel repository tramite il metodo "saveAndFlush".

Read All: l'operazione GET "/cars/getall" restituisce una lista di tutti gli oggetti "Car" presenti nel repository tramite il metodo "findAll".

Read one: l'operazione GET "/cars/get/{id}" restituisce un oggetto "Car" specifico identificato dall'ID passato come parametro di percorso.
Se l'oggetto esiste, viene restituito tramite il metodo "getById"; altrimenti, viene restituito un nuovo oggetto "Car".

Update: l'operazione PUT "/cars/update/{id}" aggiorna il tipo di un oggetto "Car" specifico identificato dall'ID passato come parametro di percorso.
Se l'oggetto esiste, viene recuperato tramite il metodo "getById", il suo tipo viene impostato e quindi viene salvato nel repository tramite il metodo "saveAndFlush". Altrimenti, viene restituito un nuovo oggetto "Car".

Delete (specific): l'operazione DELETE "/cars/delete/{id}" elimina un oggetto "Car" specifico identificato dall'ID passato come parametro di percorso.
Se l'oggetto esiste, viene eliminato tramite il metodo "deleteById". Altrimenti, viene impostato lo stato della risposta HTTP a 409 (conflitto).

Delete (all): l'operazione DELETE "/cars/delete/all" elimina tutti gli oggetti "Car" presenti nel repository tramite il metodo "deleteAll".
*/