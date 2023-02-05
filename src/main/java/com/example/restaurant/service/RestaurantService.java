package com.example.restaurant.service;
import com.example.restaurant.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
@Service
public class RestaurantService {
    private static List<Restaurant> restaurants=new ArrayList<>(); // In-memory database
    private static Long restaurantCount = 0L;

    static {
        restaurants.add(new Restaurant(++restaurantCount,"The Spicy Belly", "10 Main St", 9977694321L, "Indian", 20, "10:00 AM", "11:00 PM"));
        restaurants.add(new Restaurant(++restaurantCount,"The Sizzling Wok", "11 Main St",6543289210L, "Chinese", 30, "09:00 PM", "10:00 PM"));
        restaurants.add(new Restaurant(++restaurantCount,"The Cheesy Wheel", "12 Main St",9876543214L, "Italian", 25, "12:00 PM", "9:00 PM"));
        restaurants.add(new Restaurant(++restaurantCount,"The Smoky Grill", "13 Main St", 8765432988L, "BBQ", 35, "2:00 PM", "8:00 PM"));
        restaurants.add(new Restaurant(++restaurantCount,"The Fresh Bites", "17 Main St", 9567544899L, "Healthy", 15, "1:00 PM", "7:00 PM"));
    }

    public List<Restaurant> findAll() { // Business Logic
        return restaurants;
    }
    public Restaurant findById(int id){
        Predicate<? super Restaurant> predicate = restaurant -> restaurant.getId() == id;
        Restaurant restaurant = restaurants.stream().filter(predicate).findFirst().get();
        return restaurant;
    }
    public void addRestaurant(Restaurant restaurant){
        restaurants.add(restaurant);
    }
    public void deleteRestaurant(int id){
        Predicate<? super Restaurant> predicate = restaurant-> restaurant.getId()==id;
        restaurants.removeIf(predicate);
    }
    public void updateRestaurant(int id,Restaurant newRestaurant) {
        //step 1: find restaurant to be update
        //Step 2: update restaurant

        Restaurant restaurant=findById(id);// step 1

        restaurant.setId(newRestaurant.getId());
        restaurant.setName(newRestaurant.getName());
    }
}

