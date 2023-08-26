package com.cybersoft.crm.service;

import com.cybersoft.crm.model.RoleModel;
import com.cybersoft.crm.repository.RoleRepository;

import java.util.List;

public class RoleService {
    private RoleRepository roleRepository = new RoleRepository();

    public List<RoleModel> getAllRoles(){
        return roleRepository.getRoles();
    }

    public boolean deleteRolesById(int id){
        int result = roleRepository.deleteRolesById(id);
        return result > 0 ? true : false;
//        Toán tử 3 ngôi
//        Cú pháp : điều kiện ? Thoả điều kiện : không thoả điều kiện
//        if(result == 0){
//            return true;
//        }else{
//            return false;
//        }
    }

}
