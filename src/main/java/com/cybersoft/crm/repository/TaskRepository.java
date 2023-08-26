package com.cybersoft.crm.repository;

import com.cybersoft.crm.config.MysqlConnection;
import com.cybersoft.crm.model.TaskModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    public List<TaskModel> getTasks() {
        List<TaskModel> list = new ArrayList<>();
        try {
            String query = "select t.id,t.name as taskname,j.name as jobname,u.fullname,t.start_date,t.end_date,s.name as statusname\n" +
                    "from tasks t\n" +
                    "inner join jobs j\n" +
                    "on t.job_id = j.id\n" +
                    "inner join status s\n" +
                    "on t.status_id = s.id\n" +
                    "inner join users u\n" +
                    "on t.user_id = u.id";
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TaskModel taskModel = new TaskModel();

                taskModel.setId(resultSet.getInt("id"));
                taskModel.setTaskname(resultSet.getString("taskname"));
                taskModel.setJobname(resultSet.getString("jobname"));
                taskModel.setFullname(resultSet.getString("fullname"));
                taskModel.setStart_date(resultSet.getString("start_date"));
                taskModel.setEnd_date(resultSet.getString("end_date"));
                taskModel.setStatusname(resultSet.getString("statusname"));

                list.add(taskModel);
            }

            connection.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }

    public int deleteTaskById(int id){
        int result = 0;
        try{
            String query = "delete from tasks t where t.id = ?";
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
