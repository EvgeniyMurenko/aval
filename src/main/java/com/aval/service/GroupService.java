package com.aval.service;

import com.aval.dao.GroupDao;
import com.aval.dao.GroupDaoImpl;
import com.aval.domain.Group;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.SQLException;
import java.util.List;


@ManagedBean(name = "groupService")
@ApplicationScoped
public class GroupService {

    private GroupDao groupDao = new GroupDaoImpl();

    public List<Group> getAllGroups() throws SQLException {
        return groupDao.findAll();
    }
}

