package com.aval.dao;

import com.aval.domain.Param;

import java.sql.SQLException;
import java.util.List;

public interface ParamDao {
    List<Param> findAllByFunk(Long funkId) throws SQLException;
}
