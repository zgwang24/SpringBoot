package com.sain.dao;

import com.sain.model.ProType;
import com.sain.model.Record;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by zgwang on 6/20 0020.
 */
@Repository
public interface ProTypeRepository extends CrudRepository<ProType,Long> {
    @Transactional
    List<ProType> findAll();

    @Transactional
    @Modifying
    @Query(value = "update pro_type set value = ?2 where id = ?1", nativeQuery=true)
    int setProType(Integer id, Integer value);
}
