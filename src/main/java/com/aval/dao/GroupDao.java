package com.aval.dao;

import com.aval.domain.Group;

import java.sql.SQLException;
import java.util.List;

public interface GroupDao {
    List<Group> findAll() throws SQLException;
}
