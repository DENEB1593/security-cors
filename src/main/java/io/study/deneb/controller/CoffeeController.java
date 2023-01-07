package io.study.deneb.controller;

import io.study.deneb.model.Coffee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static io.study.deneb.model.Size.*;

@RestController
@RequestMapping("api/coffee")
public class CoffeeController {

  private List<Coffee> coffees = new ArrayList<>();

  public CoffeeController() {
    coffees.add(new Coffee(1, "Americano", VENTI));
    coffees.add(new Coffee(2, "Latte", GRANDE));
    coffees.add(new Coffee(3, "Chocolate milk", SHORT));
  }

  @GetMapping
  public List<Coffee> findAll() {
    return coffees;
  }

  @DeleteMapping
  public void delete(Integer id) {
    coffees.removeIf(coffee -> coffee.id().equals(id));
  }

}
