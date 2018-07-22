package com.aval.service;

import com.aval.dao.ParamDao;
import com.aval.dao.ParamDaoImpl;
import com.aval.domain.Param;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name = "paramService")
@ApplicationScoped
public class ParamService {

    private ParamDao paramDao = new ParamDaoImpl();

    public List<Param> getAllParansByFunk(Long funkId) throws SQLException {
        return paramDao.findAllByFunk(funkId);
    }

}
