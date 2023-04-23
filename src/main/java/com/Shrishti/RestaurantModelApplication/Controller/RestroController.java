package com.Shrishti.RestaurantModelApplication.Controller;

import com.Shrishti.RestaurantModelApplication.Model.Restaurent;
import com.Shrishti.RestaurantModelApplication.Service.RestroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resto-app")
public class RestroController {
    private final RestroService restoService;
    public RestroController(RestroService restoService){
        this.restoService=restoService;
    }
    @PostMapping("/add-restaurant")
    public void addResto(@RequestBody Restaurent restaurantModelClass){
        restoService.addRestaurant(restaurantModelClass);
    }
    //http://localhost:8080/api/resto-app/find-restaurant/name/{name}
    //http://localhost:8080/api/resto-app/find-restaurant/name/SagarRatna
    @GetMapping("/find-restaurant/name/{name}")
    public Restaurent findRestaurantByName(@PathVariable String name){
        return restoService.findByName(name);
    }
    //http://localhost:8080/api/resto-app/findall-restaurant
    @GetMapping("/findall-restaurant")
    public List<Restaurent> findAllRestos(){
        return restoService.findAllRestaurant();
    }
    //http://localhost:8080/api/resto-app/update-restaurant/number/{number}
    /*
    http://localhost:8080/api/resto-app/update-restaurant/number/1001
    JSON FORMAT-:
     {
        "resto_name": "Sagar Ratna",
        "resto_address": "Prayagraj",
        "resto_number": 1001,
        "resto_speciality": "5 star",
        "resto_totalstaff": 200
    }
     */
    @PutMapping("/update-restaurant/number/{number}")
    public void updateRestaurant(@PathVariable int number,@RequestBody Restaurent restaurantModelClass){
        restoService.updateRestaurant(number,restaurantModelClass);
    }
    //http://localhost:8080/api/resto-app/delete-restaurant/number/{number}
    //http://localhost:8080/api/resto-app/delete-restaurant/number/1001
    @DeleteMapping("/delete-restaurant/number/{number}")
    public void deleteRestaurant(@PathVariable int number){
        restoService.deleteRestaurant(number);
    }
}
