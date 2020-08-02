package com.couchebase.api.controller;

import com.couchebase.api.model.Person;
import com.couchebase.api.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class PersonController {


  private PersonService service;

  public PersonController(PersonService service) {
    this.service = service;
  }

  @PostMapping(value = "/persons")
  public ResponseEntity<List<Person>> save(@RequestBody List<Person> persons) {

    List<Person> personsList = service.saveAll(persons);

    if (personsList.isEmpty()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.emptyList());
    }
    return ResponseEntity.status(HttpStatus.OK)
            .body(personsList);

  }

  @GetMapping(value = "/persons")
  public List<Person> findAll() {
    return service.getAll();
  }

  @GetMapping(value = "/person/id")
  public ResponseEntity<Person> findById(@RequestParam(value = "id") String id) {


    return ResponseEntity.ok().body(service.getById(id));
  }

  @GetMapping(value = "/person/firstname")
  public ResponseEntity<Person> findByFirstName(@RequestParam(value = "firstName") String firstName) {
    return ResponseEntity.ok().body(service.getByfirstName(firstName));
  }

  @GetMapping(value = "/person/lastname")
  public ResponseEntity<Person> findByLastName(@RequestParam(value = "lastName") String lastName) {
    return ResponseEntity.ok().body(service.getBylastName(lastName));
  }

  @GetMapping(value = "/person/country")
  public ResponseEntity<List<Person>> findByCountry(@RequestParam(value = "country") String country) {
    return ResponseEntity.ok().body(service.getByCountry(country));
  }


  @DeleteMapping(value = "/persons")
  public ResponseEntity<String> deleteAll() {
    service.deleteAll();
    return ResponseEntity.ok("successfully deleted all the documents");
  }

  @DeleteMapping(value = "/person/{id}")
  public ResponseEntity<String> deleteById(@PathVariable String id) {
    service.deleteById(id);
    return ResponseEntity.ok("successfully deleted userId :::" + id);
  }

  @GetMapping(value = "/person/count")
  public ResponseEntity<Long> getCount() {
    return ResponseEntity.ok(service.count());
  }

}
