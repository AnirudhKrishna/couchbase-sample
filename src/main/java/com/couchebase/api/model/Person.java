package com.couchebase.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import com.couchbase.client.java.repository.annotation.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(expiryExpression = "${person.document.expiry}")
@Builder
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
  private String id;
  @Field(value = "firstname")
  private String firstname;
  @Field
  private String lastname;
  @Field
  private String country;
  @Field
  private String company;
}
