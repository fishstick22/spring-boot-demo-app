package org.dnsalias.muppets.demo.service;

import java.util.List;

import org.dnsalias.muppets.demo.entity.Person;

public interface IPersonService {
     List<Person> getAllPersons();
     Person getPersonById(int pid);
     boolean addPerson(Person person);
     void updatePerson(Person person);
     void deletePerson(int pid);
}
