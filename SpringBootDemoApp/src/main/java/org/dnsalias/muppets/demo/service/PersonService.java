package org.dnsalias.muppets.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.dnsalias.muppets.demo.dao.PersonRepositiory;
import org.dnsalias.muppets.demo.entity.Person;
@Service
public class PersonService implements IPersonService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PersonRepositiory personDAO;
	@Override
	public Person getPersonById(int pid) {
		Person obj = personDAO.findOne(pid);
		return obj;
	}	
	@Override
	public List<Person> getAllPersons(){
		return personDAO.findAll();
	}
	@Override
	public synchronized boolean addPerson(Person person){
       if (personDAO.existsByName(person.getName())) {
    	   logger.debug("addPerson "+ person.getName() + " already Exists!");
    	   return false;
       } else {
    	   personDAO.save(person);
    	   return true;
       }
	}
	@Override
	public void updatePerson(Person person) {
		personDAO.save(person);
	}
	@Override
	public void deletePerson(int pid) {
		personDAO.delete(pid);
	}
}
