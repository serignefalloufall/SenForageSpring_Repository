package com.simplon.senForageSpringProject.dao;

import com.simplon.senForageSpringProject.entities.Roles;
import com.simplon.senForageSpringProject.entities.Village;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVillage extends JpaRepository<Village,Integer> {
}
