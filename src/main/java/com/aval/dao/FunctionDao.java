package com.aval.dao;

import com.aval.domain.Function;

import java.sql.SQLException;
import java.util.List;


public interface FunctionDao {
    List<Function> findAllByGroup(Long groupId) throws SQLException;

    void update(Function function);
}
