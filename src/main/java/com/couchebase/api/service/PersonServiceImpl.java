package com.couchebase.api.service;

import com.couchebase.api.model.Person;
import com.couchebase.api.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

  private PersonRepository personRepository;

  public PersonServiceImpl(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public List<Person> saveAll(List<Person> persons) {
    Iterable<Person> people = personRepository.saveAll(persons);
    return (List<Person>) people;
  }

  @Override
  public List<Person> getAll() {
    return (List<Person>) personRepository.findAll();
  }

  @Override
  public void deleteAll() {


    personRepository.deleteAll();
  }

  @Override
  public Person getById(String id) {
    Optional<Person> person = personRepository.findById(id);
    if (person.isPresent()) {
      return person.get();
    } else throw new IllegalArgumentException("person not found in db");

  }

  @Override
  public Person getByfirstName(String firstname) {
    return personRepository.findByFirstname(firstname);
  }

  @Override
  public Person getBylastName(String lastname) {
    return personRepository.findByLastname(lastname);
  }

  @Override
  public List<Person> getByCountry(String country) {

    return personRepository.findByCountry_IgnoreCase(country);
  }

  @Override
  public void deleteById(String id) {
    personRepository.deleteById(id);
  }

  @Override
  public long count() {
    return personRepository.count();
  }
}
