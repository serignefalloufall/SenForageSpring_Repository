package com.simplon.senForageSpringProject.controller;

import com.simplon.senForageSpringProject.dao.IVillage;
import com.simplon.senForageSpringProject.entities.Village;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestController {

    //Si on utilise ModelAndView ce la ve dire que on retourne la view ainsi que les donne associe
    @Autowired
    private IVillage villagedao;

    @RequestMapping(value = "Test/liste")
    public ModelAndView liste()
    {
        List<Village> villages = villagedao.findAll();
        return new ModelAndView("village/tamplate","liste_village",villages);
    }
    @RequestMapping(value = "test")
    public ModelAndView test()
    {
        List<Village> villages = villagedao.findAll();
        return new ModelAndView("village/tamplate","liste_village",villages);
    }
}
