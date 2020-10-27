package com.simplon.senForageSpringProject.controller;

import com.simplon.senForageSpringProject.dao.IClient;
import com.simplon.senForageSpringProject.dao.IUser;
import com.simplon.senForageSpringProject.dao.IVillage;
import com.simplon.senForageSpringProject.entities.Client;
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
public class ClientController {
    @Autowired
    private IUser userdao;
    @Autowired
    private IVillage villagedao;
    @Autowired
    private IClient clientdao;

    @RequestMapping(value = "/listeclient")
    public String listeClient(ModelMap model)
    {
        //on utilise le ModelMap lorsqu'on veux charger des donnees de plusieur source
        List<User> users = userdao.findAll();
        List<Village> villages = villagedao.findAll();
        List<Client> clients = clientdao.findAll();


        model.put("liste_users",users);
        model.put("liste_villages",villages);
        model.put("liste_clients",clients);

        model.put("client", new Client());

        return "client/add";
    }

    @RequestMapping(value = "Client/add", method = RequestMethod.POST)
    public String addClient(
                            String adresse, String nom,
                            String prenom,String tel,
                            int user_id,int village_id)
    {
        ModelAndView modelAndView = new ModelAndView();

        Client client = new Client();

        client.setAdresse(adresse);
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setTel(tel);

        User user = new User();
        user = userdao.getOne(user_id);

        Village village = new Village();
        village = villagedao.getOne(village_id);

        client.setUser(user);
        client.setVillage(village);

        try {

            clientdao.save(client);
            clientdao.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/listeclient";
    }


    @RequestMapping(value = "Client/edit", method = RequestMethod.GET)
    public String editClient(int id, ModelMap model)
    {
        List<User> users = userdao.findAll();
        List<Village> villages = villagedao.findAll();
        List<Client> clients = clientdao.findAll();

        Client client = clientdao.getOne(id);

        model.put("liste_users",users);
        model.put("liste_villages",villages);
        model.put("liste_clients",clients);

        model.put("client",client);


        return "client/add";
    }


    @RequestMapping(value = "Client/delete", method = RequestMethod.GET)
    public String deleteVillage(int id)
    {
        try {
            clientdao.delete(clientdao.getOne(id));
            clientdao.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/listeclient";
    }
}
