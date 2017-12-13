package com.sain.dao;

import com.sain.model.Admin;
import com.sain.model.Salesman;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zgwang on 6/20 0020.
 */
@Repository
public interface AdminRepository extends CrudRepository<Admin,String> {
    @Query(value = "select * from admin where name=?1 and pass=?2", nativeQuery=true)
    List<Admin> verify(String name, String pass);
}
