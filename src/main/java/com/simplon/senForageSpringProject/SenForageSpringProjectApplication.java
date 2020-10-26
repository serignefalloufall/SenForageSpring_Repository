package com.simplon.senForageSpringProject;

import com.simplon.senForageSpringProject.dao.IRoles;
import com.simplon.senForageSpringProject.dao.IUser;
import com.simplon.senForageSpringProject.entities.Roles;
import com.simplon.senForageSpringProject.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SenForageSpringProjectApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SenForageSpringProjectApplication.class, args);
		//on va utiliser cette context pour charger les beans

		//**********TEST AJOUT ROLE**********
		/*Roles roles = new Roles	();
		roles.setId(1);
		roles.setNom("ROLE_USER");


		User u = new User();
		u.setId(1);
		u.setNom("Fall");
		u.setPrenom("Serigne Fallou");
		u.setEmail("fallfallou37@gmail.com");
		u.setPassword("passer");
		u.setEtat(1);

		List<Roles> roless = new ArrayList<>();
		roless.add(roles);
		u.setRoles(roless);

		IUser iuser = ctx.getBean(IUser.class);
		try {
			iuser.save(u);
			System.out.println("yessss");
		}catch (Exception e){
			e.printStackTrace();
		}*/


		/*IRoles iroles = ctx.getBean(IRoles.class);
		List<User> users = new ArrayList<User>();
		users.add(u);
		roles.setUsers(users);
		try {
			iroles.save(roles);
			System.out.println("yessss");
		}catch (Exception e){
			e.printStackTrace();
		}
*/


		//**********TEST AJOUT USER**********
		/*IUser iuser = ctx.getBean(IUser.class);
		User u = new User();
		u.setId(1);
		u.setNom("Fall");
		u.setPrenom("Serigne Fallou");
		u.setEmail("fallfallou37@gmail.com");
		u.setPassword("passer");
		u.setEtat(1);
		try {
				iuser.save(u);
				System.out.println("yessss");
		}catch (Exception e){
			e.printStackTrace();
		}*/

	}


}
