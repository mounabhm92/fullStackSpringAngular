package com.sip.ams.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Entities.Etudiant;
@RequestMapping("/etudiant")
@Controller
public class EtudiantController {
	List<Etudiant> etudiants = new ArrayList<>();
	{
		etudiants.add(new Etudiant(1,"mouna","mouna@gmail.com"));
		etudiants.add(new Etudiant(2,"sabry","sabry@gmail.com"));
		etudiants.add(new Etudiant(3,"yaakoub","yaakoub@gmail.com"));
	}

	@RequestMapping("/home")
	public String message(Model model) {
		System.out.println("bienvenue au BootCamp");
		String formation ="fullStack 100% SpringBoot";
		String lieu ="sesame";
		model.addAttribute("training", formation);
		model.addAttribute("Place", lieu);

		return "info";
	}
	
//	@RequestMapping("/Products")
//	public String listProducts(Model model) {
//		List<String> produits = new ArrayList<>();
//	
//		produits.add("Voiture");
//		produits.add("Camion");
//		produits.add("Moto");
//		produits.add("Bus");
//		model.addAttribute("mesProduits", produits);
//		return "Products";
//	}
	
	@RequestMapping("/Products")
	public ModelAndView listProduct() {
		ModelAndView model = new ModelAndView();

		List<String> produits = new ArrayList<>();
	
		produits.add("Voiture");
		produits.add("Camion");
		produits.add("Moto");
		produits.add("Bus");
		model.addObject("mesProduits", produits);
		model.setViewName("Products");

		return model;
	}
	
	@RequestMapping("/students")
	public ModelAndView listStudent() {
		ModelAndView model = new ModelAndView();

		System.out.println(this.etudiants);
		model.addObject("mesEtudiants", this.etudiants);
		model.setViewName("Listestudent");

		return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addStudentForm() {
		ModelAndView model = new ModelAndView();
		model.setViewName("addStudent");

		return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addStudent(@RequestParam("id")int id,
			@RequestParam("nomEtudiant")String NomEtudiant,
			@RequestParam("email")String email) {
		Etudiant e = new Etudiant(id,NomEtudiant,email);
		etudiants.add(e);
		return "redirect:students";
	}
	
	
	@GetMapping("/delete/{ide}")
	public String supression(@PathVariable("ide")int id) {
		System.out.println("ide ="+ id);
		Etudiant etudiant = new Etudiant();
		etudiant = recherche(etudiants, id );
		etudiants.remove(etudiant);
		return "redirect:../students";
	}
	
	private Etudiant recherche(List<Etudiant> liste , int index) {
		
		Etudiant temp = null ;
		for (Etudiant e : liste) {
			if (e.getId() == index) {
				temp = e;
				return e;
			}
		}
		
		return temp;
	}

}
