package com.simplon.senForageSpringProject.dao;

import com.simplon.senForageSpringProject.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClient extends JpaRepository<Client,Integer> {
}
