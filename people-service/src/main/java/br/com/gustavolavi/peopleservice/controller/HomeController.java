package br.com.gustavolavi.peopleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavolavi.peopleservice.model.People;
import br.com.gustavolavi.peopleservice.repository.PeopleRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class HomeController {
    
    @Autowired
    private PeopleRepository peopleRepository;

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public ResponseEntity<Iterable<People>> get(){
        return new ResponseEntity<Iterable<People>>(peopleRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public ResponseEntity<People> Post(@RequestBody People pessoa){
        return new ResponseEntity<People>(peopleRepository.save(pessoa), HttpStatus.OK);
    }

}
