package com.example.demospring.data.dao;

import com.example.demospring.data.entities.UserEntity;
import com.example.demospring.data.filter.UserFilter;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends GenericDao {
    public UserDao(EntityManager entityManager) {
        super(UserEntity.class, entityManager);
    }

    public List<UserEntity> findAdminWithUserName(String userName){
        UserFilter filter = new UserFilter();
        filter.setEmail(userName);
        return get(filter);
    }

}
