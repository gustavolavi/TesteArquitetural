package br.com.gustavolavi.peopleservice.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.gustavolavi.peopleservice.model.People;


/**
 * PeopleRepository
 */
public interface PeopleRepository extends CrudRepository<People,Long>{

}