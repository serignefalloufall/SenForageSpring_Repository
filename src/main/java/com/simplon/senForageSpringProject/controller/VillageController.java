package com.simplon.senForageSpringProject.controller;

import com.simplon.senForageSpringProject.dao.IUser;
import com.simplon.senForageSpringProject.dao.IVillage;
import com.simplon.senForageSpringProject.entities.User;
import com.simplon.senForageSpringProject.entities.Village;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class VillageController {
    @Autowired
    private IUser userdao;
    @Autowired
    private IVillage villagedao;

    @RequestMapping(value = "Village/liste")
    public String listeVillage(ModelMap model)
    {
        //on utilise le ModelMap lorsqu'on veux charger des donnees de plusieur source
        List<User> users = userdao.findAll();
        List<Village> villages = villagedao.findAll();


        model.put("liste_users",users);
        model.put("liste_village",villages);

        return "village/add";
    }

    @RequestMapping(value = "Village/add", method = RequestMethod.POST)
    public String addVillage(String nom, int id_user)
    {
        ModelAndView modelAndView = new ModelAndView();

        Village village = new Village();
        village.setNom(nom);

        User user = new User();
        user = userdao.getOne(id_user);

        village.setUser(user);

        try {

            villagedao.save(village);
            modelAndView.addObject("resultat", new String("Village ajoute avec succe"));
        }catch (Exception e){

            modelAndView.addObject("resultat", new String("Village non ajoute"));
        }
        return "village/add";
    }
}
