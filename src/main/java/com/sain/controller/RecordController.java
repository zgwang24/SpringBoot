package com.sain.controller;

import com.sain.dao.RecordRepository;
import com.sain.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sain.model.Incentive;
import com.sain.model.RecordRes;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * Created by zgwang on 6/20 0020.
 */
@RestController
public class RecordController {

    @Autowired
    RecordRepository recordRepository;

    @RequestMapping(value = "/record/get", method = RequestMethod.GET)
    public List<RecordRes> getRecord(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<RecordRes>  recordList = recordRepository.findAllRecord();
        return recordList;
    }

    @RequestMapping(value = "/record/set", method = RequestMethod.POST)
    public Record setRecord(@RequestBody Record record) {
        recordRepository.save(record);
        return record;
    }

    @RequestMapping(value = "/record/getByType", method = RequestMethod.GET)
    public List<RecordRes> getRecordByType(
            @RequestParam(value="typeId") Integer typeId,
            HttpServletResponse response
        ){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<RecordRes> records = recordRepository.getRecordByType(typeId);
        return records;
    }

    @RequestMapping(value = "/record/all/group", method = RequestMethod.GET)
    public List<Incentive> getRecordByGroup(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Incentive> records = recordRepository.getRecordByGroup();
        return records;
    }
}
