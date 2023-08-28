package com.cybersoft.crm.repository;

import com.cybersoft.crm.config.MysqlConnection;
import com.cybersoft.crm.model.JobModel;
import com.cybersoft.crm.model.RoleModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JobRepository {
    public List<JobModel> getJobs(){
        List<JobModel> list = new ArrayList<>();
        try{
            String query = "select * from jobs";
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                JobModel jobModel = new JobModel();
                jobModel.setId(resultSet.getInt("id"));
                jobModel.setName(resultSet.getString("name"));
                jobModel.setStartDate(resultSet.getString("start_date"));
                jobModel.setEndDate(resultSet.getString("end_date"));

                list.add(jobModel);
            }

            connection.close();

        }catch (Exception e){
            System.out.println("Error getJob " + e.getMessage());
        }

        return list;
    }

    public int deleteJobById(int id){
        int result = 0;
        try{
            String query = "delete from jobs j where j.id = ?";
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);

            result = preparedStatement.executeUpdate();
            connection.close();

        }catch (Exception e){
            System.out.println("Error getJobById " + e.getMessage());
        }

        return result;
    }
}
