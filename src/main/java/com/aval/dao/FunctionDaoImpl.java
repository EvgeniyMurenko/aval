package com.aval.dao;

import com.aval.config.JdbcConfig;
import com.aval.domain.Function;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FunctionDaoImpl implements FunctionDao {

    private JdbcConfig config = new JdbcConfig();

    @Override
    public List<Function> findAllByGroup(Long groupId) throws SQLException {
        Connection connection = config.getConnection();
        ResultSet resultSetFunction = null;
        String select = "SELECT * FROM FUNCTIONS WHERE ID_GROUP = "+groupId+" ORDER BY ID";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            resultSetFunction = preparedStatement.executeQuery();

            List<Function> functionList = new ArrayList<>();
            while (resultSetFunction.next()){
                Function function = new Function();
                function.setId(Long.valueOf(resultSetFunction.getString("ID")));
                function.setGroupId(Long.valueOf(resultSetFunction.getString("ID_GROUP")));
                function.setName(resultSetFunction.getString("NAME"));
                function.setDescr(resultSetFunction.getString("DESCR"));
                function.setDate(resultSetFunction.getString("CTIME"));
                function.setActive(resultSetFunction.getBoolean("ACTIVE"));

                /*count functions*/
                String countSelect = "SELECT COUNT(distinct id) as count FROM FUN_PARAM WHERE ID_FUN = "+function.getId();
                ResultSet countResultSet = connection.prepareStatement(countSelect).executeQuery();
                while (countResultSet.next()){
                    function.setCountParam(countResultSet.getInt("count"));
                }

                functionList.add(function);
            }

            return functionList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }

        return null;
    }

    @Override
    public void update(Function function){
        Connection connection = config.getConnection();
        int boleanValue = 0;
        if(function.isActive()){
            boleanValue = 1;
        }
        String update = "UPDATE FUNCTIONS SET NAME = '"+function.getName()+"', DESCR = '"+function.getDescr()+"', ACTIVE = "+boleanValue+" WHERE ID = "+function.getId();
        System.out.println();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
