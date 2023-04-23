package com.Shrishti.RestaurantModelApplication.Service;

import com.Shrishti.RestaurantModelApplication.Model.Restaurent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

    // add Restaurant in the List
    public void addRestaurant(Restaurent resto){
        restos.add(resto);
    }

    //find all restaurant in the List
    public List<Restaurent> findAllRestaurant(){ return restos; }

    // find Restaurant by Name
    public Restaurent findByName( String name){
        Predicate<? super Restaurent> predicate = rest -> rest.getResto_name().equals(name);
        Restaurent rest=restos.stream().filter(predicate).findFirst().get();
        return rest;
    }

    // find Restaurant by Number
    public Restaurent findByNumber( int number){
        Predicate<? super Restaurent> predicate = rest -> rest.getResto_number()==number;
        Restaurent rest=restos.stream().filter(predicate).findFirst().get();
        return rest;
    }

    //number work as restaurant id and delete it.
    public void deleteRestaurant(int number){
        Predicate<? super Restaurent> predicate=rest ->rest.getResto_number()==number;
        restos.removeIf(predicate);
    }

    //Update Restaurant Information
    public void updateRestaurant(int number, Restaurent newrest){
        Restaurent rest=findByNumber(number);
        rest.setResto_name(newrest.getResto_name());
        rest.setResto_address(newrest.getResto_address());
        rest.setResto_number(newrest.getResto_number());
        rest.setResto_speciality(newrest.getResto_speciality());
        rest.setResto_totalstaff(newrest.getResto_totalstaff());
    }
}
