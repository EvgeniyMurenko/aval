package com.aval.dao;

import com.aval.config.JdbcConfig;
import com.aval.domain.Param;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ParamDaoImpl implements ParamDao {
    private JdbcConfig config = new JdbcConfig();

    @Override
    public List<Param> findAllByFunk(Long funkId) throws SQLException {
        Connection connection = config.getConnection();
        ResultSet resultSetParam = null;
        String select = "SELECT * FROM FUN_PARAM WHERE ID_FUN = "+funkId;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            resultSetParam = preparedStatement.executeQuery();

            List<Param> paramList = new ArrayList<>();
            while (resultSetParam.next()){
                Param param = new Param();
                param.setId(Long.valueOf(resultSetParam.getString("ID")));
                param.setFunkId(Long.valueOf(resultSetParam.getString("ID_FUN")));
                param.setName(resultSetParam.getString("NAME"));
                param.setDescr(resultSetParam.getString("DESCR"));
                param.setDate(resultSetParam.getString("CTIME"));

                paramList.add(param);
            }
            return paramList;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }

        return null;
    }
}
