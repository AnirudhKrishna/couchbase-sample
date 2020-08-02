package com.couchebase.api.service;

import com.couchebase.api.model.Person;

import java.util.List;

public interface PersonService {
  List<Person> saveAll(List<Person> persons);

  List<Person> getAll();

  void deleteAll();

  Person getById(String id);

  Person getByfirstName(String firstname);

  Person getBylastName(String lastname);

  List<Person> getByCountry(String county);

  void deleteById(String id);

  long count();

}
