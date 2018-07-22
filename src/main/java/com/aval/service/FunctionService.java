package com.aval.service;

import com.aval.dao.FunctionDao;
import com.aval.dao.FunctionDaoImpl;
import com.aval.domain.Function;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name = "functionService")
@ApplicationScoped
public class FunctionService {

    private FunctionDao functionDao = new FunctionDaoImpl();

    public List<Function> getAllGroups(Long groupId) throws SQLException {
        return functionDao.findAllByGroup(groupId);
    }

    public void updateFunction(Function function){
        functionDao.update(function);
    }
}
