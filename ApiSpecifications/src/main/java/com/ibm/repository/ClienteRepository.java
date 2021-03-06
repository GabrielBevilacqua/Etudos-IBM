package com.ibm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ibm.model.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long>, JpaSpecificationExecutor<ClienteModel> {

}
