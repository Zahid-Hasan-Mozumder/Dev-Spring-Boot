package com.zhm.springboot.personal_project.AskForHelp.DAO;

import com.zhm.springboot.personal_project.AskForHelp.entity.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "queries")
public interface QueriesDAO extends JpaRepository<Query, Integer> {

}
