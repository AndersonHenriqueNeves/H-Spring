package br.com.springboot.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.model.Temperatura;
import br.com.springboot.repository.TemperaturaRepository;


@RestController
@RequestMapping("/temperaturas")
public class TemperaturaController {

  @Autowired
  private TemperaturaRepository temperaturaRepository;
  

  @PostMapping("/")
  public Temperatura create(@RequestBody Temperatura temperatura) {
	
	return this.temperaturaRepository.save(temperatura);
  }
  
  
  @RequestMapping(path = "/dates/{startDate}/{endDate}/{id_galpao}", method = RequestMethod.GET)
  public List<Temperatura> index(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date startDate, @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date endDate, @PathVariable("id_galpao") Long id_galpao) {
	
	return this.temperaturaRepository.getAllBetweenDates(startDate, endDate, id_galpao);
  } 
  

}