package com.zhm.springboot.personal_project.AskForHelp.services;

import com.zhm.springboot.personal_project.AskForHelp.DAO.QueriesDAO;
import com.zhm.springboot.personal_project.AskForHelp.entity.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QueryServiceImpl implements QueryService{

    private QueriesDAO theQueriesDAO;

    @Autowired
    public QueryServiceImpl(QueriesDAO theQueriesDAO){
        this.theQueriesDAO = theQueriesDAO;
    }

    @Override
    public Query save(Query theQuery) {
        return theQueriesDAO.save(theQuery);
    }

    @Override
    public List<Query> findAll() {
        return theQueriesDAO.findAll();
    }

    @Override
    public Query findById(int id) {
        Optional<Query> res = theQueriesDAO.findById(id);
        Query theQuery = null;
        if(res.isPresent())
            theQuery = res.get();
        return theQuery;
    }

    @Override
    public void deleteById(int id) {
        theQueriesDAO.deleteById(id);
    }

}
