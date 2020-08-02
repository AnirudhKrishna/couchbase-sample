package com.couchebase.api.repository;

import com.couchebase.api.model.Person;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "person")
public interface PersonRepository extends CouchbaseRepository<Person, String> {

  Person findByFirstname(String firstname);

  Person findByLastname(String lastname);

  List<Person> findByCountry_IgnoreCase(String country);
//  Page<Person> findByCountry_IgnoreCase(String country, Pageable page);
//  Slice<Person> findByCountry_IgnoreCase(String country, Pageable page);
}
