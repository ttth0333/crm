package com.cybersoft.crm.service;

import com.cybersoft.crm.model.UsersModel;
import com.cybersoft.crm.repository.UsersRepository;

import java.util.List;

public class LoginService {

    UsersRepository usersRepository = new UsersRepository();

    public boolean checkLogin(String email, String password){
        List<UsersModel> list = usersRepository.getUsersByEmailAndPassword(email,password);
        if(list.size() > 0){
            //Đăng nhập thành công
            return true;
        }else{
            //Đăng nhập thất bại
            return false;
        }

    }

}
