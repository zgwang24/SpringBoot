package com.sain.dao;

import com.sain.model.Incentive;
import com.sain.model.Record;
import com.sain.model.RecordRes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zgwang on 6/19 0019.
 */
@Repository
public interface RecordRepository extends CrudRepository<Record,Long> {

    @Query(value = "select r.name name, r.phone, s.name as salesman, p.name type from record r left join salesman s on r.salesman_id = s.id left join pro_type p on r.type_id = p.id", nativeQuery=true)
    List<RecordRes> findAllRecord();

    @Query(value = "select r.name name, r.phone, s.name as salesman, p.name type from record r left join salesman s on r.salesman_id = s.id left join pro_type p on r.type_id = p.id where r.type_id = ?1", nativeQuery=true)
    List<RecordRes> getRecordByType(Integer typeId);

    @Query(value = "select s.name, sum(p.value) sum from record r left join pro_type p on r.type_id = p.id left join salesman s on r.salesman_id = s.id group by r.salesman_id order by sum desc", nativeQuery=true)
    List<Incentive> getRecordByGroup();
}
