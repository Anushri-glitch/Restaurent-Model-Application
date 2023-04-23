package com.Shrishti.RestaurantModelApplication.Controller;

import com.Shrishti.RestaurantModelApplication.Model.Restaurent;
import com.Shrishti.RestaurantModelApplication.Service.RestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restro-app")
public class RestroController {
    @Autowired
    RestroService restoService;
    public RestroController(RestroService restoService){
        this.restoService=restoService;
    }
    @PostMapping("/add-restaurent")
    public void addResto(@RequestBody Restaurent restaurantModelClass){
        restoService.addRestaurant(restaurantModelClass);
    }
    //http://localhost:8080/api/restro-app/find-restaurant/name/{name}
    //http://localhost:8080/api/restro-app/find-restaurant/name/SagarRatna
    @GetMapping("/find-restaurent/name/{name}")
    public Restaurent findRestaurantByName(@PathVariable String name){
        return restoService.findByName(name);
    }
    //http://localhost:8080/api/restro-app/findall-restaurent
    @GetMapping("/findall-restaurent")
    public List<Restaurent> findAllRestos(){
        return restoService.findAllRestaurant();
    }
    //http://localhost:8080/api/resto-app/update-restaurent/number/{number}
    /*
    http://localhost:8080/api/restro-app/update-restaurent/number/1001
    JSON FORMAT-:
     {
        "resto_name": "Sagar Ratna",
        "resto_address": "Prayagraj",
        "resto_number": 1001,
        "resto_speciality": "5 star",
        "resto_totalstaff": 200
    }
     */
    @PutMapping("/update-restaurent/number/{number}")
    public void updateRestaurant(@PathVariable int number,@RequestBody Restaurent restaurantModelClass){
        restoService.updateRestaurant(number,restaurantModelClass);
    }
    //http://localhost:8080/api/resto-app/delete-restaurent/number/{number}
    //http://localhost:8080/api/resto-app/delete-restaurent/number/1001
    @DeleteMapping("/delete-restaurent/number/{number}")
    public void deleteRestaurant(@PathVariable int number){
        restoService.deleteRestaurant(number);
    }
}
