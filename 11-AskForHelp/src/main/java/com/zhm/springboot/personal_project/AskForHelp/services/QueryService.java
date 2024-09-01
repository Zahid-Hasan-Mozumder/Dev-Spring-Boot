package com.zhm.springboot.personal_project.AskForHelp.services;

import com.zhm.springboot.personal_project.AskForHelp.entity.Query;

import java.util.List;

public interface QueryService {

    public Query save(Query theQuery);

    public List<Query> findAll();

    public Query findById(int id);

    public void deleteById(int id);
}
