package com.restapi.kafka.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.kafka.model.Person;
import com.restapi.kafka.model.Tutorial;
import com.restapi.kafka.service.PersonService;
import com.restapi.kafka.service.TutorialService;

@RestController
@RequestMapping("/api")
public class PersonController {
//  @Autowired
//  TutorialService tutorialService;
  
  @Autowired
  PersonService personService;

  private static final String TOPIC = "KafkaPerson";
	
  @Autowired
  KafkaTemplate<String, Person> kafkaTemplatePerson;
  
  @PostMapping("/person")
  public Person createTutorial(@RequestBody Person person) {
	  kafkaTemplatePerson.send(TOPIC,person);
    return personService.savePerosn(person);
  }
  
  @GetMapping("allpersons")
  public List<Person> getAllPersonList()
  {
	  return personService.getAllperson();
  }
  
//  @GetMapping("/tutorials")
//  public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
//    try {
//      List<Tutorial> tutorials = new ArrayList<Tutorial>();
//
//      if (title == null)
//        tutorialService.findAll().forEach(tutorials::add);
//      else
//        tutorialService.findByTitleContaining(title).forEach(tutorials::add);
//
//      if (tutorials.isEmpty()) {
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//      }
//
//      return new ResponseEntity<>(tutorials, HttpStatus.OK);
//    } catch (Exception e) {
//      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }
//
//  @GetMapping("/tutorials/{id}")
//  public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
//    Tutorial tutorial = tutorialService.findById(id);
//
//    if (tutorial != null) {
//      return new ResponseEntity<>(tutorial, HttpStatus.OK);
//    } else {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//  }

//  @PostMapping("/tutorials")
//  public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
//    try {
//      Tutorial _tutorial = tutorialService
//          .save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
//      return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
//    } catch (Exception e) {
//      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }

//  @PutMapping("/tutorials/{id}")
//  public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
//    Tutorial _tutorial = tutorialService.findById(id);
//
//    if (_tutorial != null) {
//      _tutorial.setTitle(tutorial.getTitle());
//      _tutorial.setDescription(tutorial.getDescription());
//      _tutorial.setPublished(tutorial.isPublished());
//      return new ResponseEntity<>( tutorialService.save(_tutorial), HttpStatus.OK);
//    } else {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//  }
//
//  @DeleteMapping("/tutorials/{id}")
//  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
//    try {
//      tutorialService.deleteById(id);
//      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    } catch (Exception e) {
//      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }
//
//  @DeleteMapping("/tutorials")
//  public ResponseEntity<HttpStatus> deleteAllTutorials() {
//    try {
//      tutorialService.deleteAll();
//      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    } catch (Exception e) {
//      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//  }
}
