package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;

    @PostConstruct
    public void init(){
        animals=new HashMap<>();
    }

   @GetMapping
    public List<Animal> getAllANimals(){
       return new ArrayList<>(animals.values()); //1.
       // 2. seçenek return animals.values().stream().toList()
   }

   @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable("id") Integer id){
        return animals.get(id);
   }

   @PostMapping
    public Animal createAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(),animal);
        return animal;
   }

   @PutMapping("/{id}")
    public Animal updateAnimalById(@PathVariable("id") Integer id,@RequestBody Animal animal){
        animal.setId(id);
        animals.put(id,animal);
        return animal;
   }
   @DeleteMapping("/{id}")
    public Animal removeAnimal(@PathVariable("id") Integer id){
        Animal removeAnimal=animals.remove(id);
        return removeAnimal;
   }
}
