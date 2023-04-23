# Restaurent-Model-Application
##### :purple_square: Its a Web Application
## :one: Frameworks and Languages Used -
    1. SpringBoot
    2. JAVA
    3. Postman
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
## :two: Dataflow (Functions Used In)
### :purple_square: 1. Model - Model is used to Iniitialize the required attributes and create the accessable constructors and methods
#### :o: Restaurent.java
```java
public class Restaurent {
    private String resto_name;
    private String resto_address;
    private int resto_number;
    private String resto_speciality;
    private int resto_totalstaff;

    public Restaurent() {
    }

    public Restaurent(String resto_name, String resto_address, int resto_number, String resto_speciality, int resto_totalstaff) {
        this.resto_name = resto_name;
        this.resto_address = resto_address;
        this.resto_number = resto_number;
        this.resto_speciality = resto_speciality;
        this.resto_totalstaff = resto_totalstaff;
    }

    public String getResto_name() {
        return resto_name;
    }
}
```

##### To See Model
:white_check_mark: [Restaurent-Model](https://github.com/Anushri-glitch/Restaurent-Model-Application/tree/master/src/main/java/com/Shrishti/RestaurantModelApplication/Model)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

### :purple_square: 2. Service - This Layer is used to write the logic of our CRUD operaions in RestroService.java
#### :o: RestroService.java
```java
@Service
public class RestroService {
    private static List<Restaurent> restos = new ArrayList<>();
    static {
        restos.add(new Restaurent("SagarRatna","Prayagraj",1001,"5 star",200));
        restos.add(new Restaurent("HaldiRam","Prayagraj",1002,"4.3 star",160));
        restos.add(new Restaurent("City Mall","Kota",1003,"5 star",200));
        restos.add(new Restaurent("baati chokha","Jaunpur",1004,"3 star",150));
        restos.add(new Restaurent("Dosa Plaza","Prayagraj",1005,"7 star",350));
    }

    public void addRestaurant(Restaurent resto){
        restos.add(resto);
    }

    public List<Restaurent> findAllRestaurant(){ return restos; }

    public Restaurent findByName( String name){
        Predicate<? super Restaurent> predicate = rest -> rest.getResto_name().equals(name);
        Restaurent rest=restos.stream().filter(predicate).findFirst().get();
        return rest;
    }
}
```

#### To See Service
:white_check_mark: [Restaurent-Service](https://github.com/Anushri-glitch/Restaurent-Model-Application/tree/master/src/main/java/com/Shrishti/RestaurantModelApplication/Service)
----------------------------------------------------------------------------------------------------------------------------------------------------

### :purple_square: 3. Controller - This Controller is used to like UI between Model and Service and also for CRUD Mappings in RestroController.java
#### :o: RestroController.java
```java
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
    @GetMapping("/find-restaurent/name/{name}")
    public Restaurent findRestaurantByName(@PathVariable String name){
        return restoService.findByName(name);
    }
}
```

#### To See Controller
:white_check_mark: [Restaurent-Controller](https://github.com/Anushri-glitch/Restaurent-Model-Application/tree/master/src/main/java/com/Shrishti/RestaurantModelApplication/Controller)

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
## :three: DataStructures Used in Project
    1. ArrayList
-------------------------------------------------------------------------------------------------------------------------------------------------------
## :four: Project Summary
### :o: Project result 
#### :purple_square: POST API : http://localhost:8080/api/restro-app/add-restaurent
![Resto1](https://user-images.githubusercontent.com/47708011/233851125-44d7f252-ad31-4acc-9605-35f449621ba7.png)

#### :purple_square: GET API (For All Restaurent) : http://localhost:8080/api/restro-app/findAll-restaurent
![Resto2](https://user-images.githubusercontent.com/47708011/233851173-77dc0f0e-48a1-4b26-b60b-24d6ee31c8e6.png)

#### :purple_square: PUT API (For All Restaurent) : http://localhost:8080/api/restro-app/update-restaurent/number/{number}
![Resto4](https://user-images.githubusercontent.com/47708011/233851239-fa5f747d-67bc-4731-a4db-1dce91454567.png)
![Resto5](https://user-images.githubusercontent.com/47708011/233851283-6d276b1d-a0d7-41a7-88be-ddb9fabde2ed.png)

#### :purple_square: PUT API (For All Restaurent) : http://localhost:8080/api/restro-app/delete-restaurent/number/1001
![Resto7](https://user-images.githubusercontent.com/47708011/233851360-7b1f66f5-0889-494e-99ac-5a15c85b7b3d.png)
----------------------------------------------------------------------------------------------------------------------------------------------------------






