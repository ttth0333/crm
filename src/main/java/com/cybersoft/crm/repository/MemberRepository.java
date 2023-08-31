package com.cybersoft.crm.repository;

import com.cybersoft.crm.config.MysqlConnection;
import com.cybersoft.crm.model.MemberModel;
import com.cybersoft.crm.model.RoleModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    public List<MemberModel> getMembers() {
        List<MemberModel> list = new ArrayList<>();
        try{
            String query = "select u.id, u.fullname, u.email, r.name as rolename\n" +
                    "from users u\n" +
                    "inner join roles r\n" +
                    "on u.role_id = r.id";
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                MemberModel memberModel = new MemberModel();
                memberModel.setId(resultSet.getInt("id"));
                memberModel.setFullname(resultSet.getString("fullname"));
                memberModel.setUsername(resultSet.getString("email"));
                memberModel.setRolename(resultSet.getString("rolename"));


                list.add(memberModel);
            }

            connection.close();

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        return list;
    }

    public int deleteMemberById(int id){
        int result = 0;
        try{
            String query = "delete from users u where u.id = ?";
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);

            result = preparedStatement.executeUpdate();
            connection.close();

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        return result;
    }
}
