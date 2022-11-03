package com.samulitori.tori.web;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.samulitori.tori.domain.CategoryRepository;
import com.samulitori.tori.domain.Listing;
import com.samulitori.tori.domain.ListingRepository;
import com.samulitori.tori.domain.UserRepository;

@Controller
public class ListingController {
    
    @Autowired
    private ListingRepository listingRepo;
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private UserRepository userRepo;


    @GetMapping(value={"/", "/index"})
    public String getListings(Model model){
        model.addAttribute("listings", listingRepo.findAll());
        return "index";
    }

    @GetMapping(value=("/delete/{id}"))
    public String deleteListing(@PathVariable("id") Long listingId, Model model){
        listingRepo.deleteById(listingId);
        return "redirect:../index";
    }

    @GetMapping("/addlisting")
    public String addListing(Principal principal, Model model){
        model.addAttribute("listing", new Listing());
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("user", userRepo.findByUsername(principal.getName()));
        return "addlisting";
    }

    @GetMapping(value="/listing/{id}")
    public String showListing(Principal principal, @PathVariable("id") Long listingId, Model model){
        model.addAttribute("listings", listingRepo.findById(listingId).get());
        model.addAttribute("user", userRepo.findByUsername(principal.getName()));
        return "listing";
    }

    @PostMapping(value = "/save")
    public String saveListing(@ModelAttribute Listing newListing, Model model){
        listingRepo.save(newListing);
        return "redirect:index";
    }
}
