package com.aval.dao;

import com.aval.config.JdbcConfig;
import com.aval.domain.Group;
import com.sun.prism.PresentableState;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GroupDaoImpl implements GroupDao {

    private JdbcConfig config = new JdbcConfig();

    @Override
    public List<Group> findAll() throws SQLException {

        Connection connection = config.getConnection();

        ResultSet resultSet = null;
        String select = "SELECT * FROM GROUP_FUNCTION ORDER BY ID";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            resultSet = preparedStatement.executeQuery();
            List<Group> groupList = new ArrayList<>();
            while (resultSet.next()){
                Group group = new Group();
                group.setId(Long.valueOf(resultSet.getString("ID")));
                group.setName(resultSet.getString("NAME"));
                group.setDescr(resultSet.getString("DESCR"));
                group.setDate(resultSet.getString("CTIME"));

                /*count functions*/
                String countSelect = "SELECT COUNT(distinct id) as count FROM FUNCTIONS WHERE ID_GROUP = "+group.getId();
                ResultSet countSet = connection.prepareStatement(countSelect).executeQuery();
                while (countSet.next()){
                    group.setCountFunctions(countSet.getInt("count"));
                }

				/*count active functions*/
                String countActiveSelect = "SELECT COUNT(distinct id) as count FROM FUNCTIONS WHERE ACTIVE = 1 AND ID_GROUP  = "+group.getId();
                ResultSet countActiveSet = connection.prepareStatement(countActiveSelect).executeQuery();
                while (countActiveSet.next()){
                    group.setCountActiveFunctions(countActiveSet.getInt("count"));
                }


                groupList.add(group);
            }

            return groupList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

        return null;
    }
}
