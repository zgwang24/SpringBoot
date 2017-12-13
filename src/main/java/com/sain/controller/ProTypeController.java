package com.sain.controller;

import com.sain.dao.ProTypeRepository;
import com.sain.model.ProType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * Created by zgwang on 6/20 0020.
 */
@RestController
public class ProTypeController {
    @Autowired
    ProTypeRepository proTypeRepository;

    @RequestMapping(value = "/protype/get", method = RequestMethod.GET)
    public List<ProType> getRecord(
        HttpServletResponse response
    ) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<ProType>  proTypeList = proTypeRepository.findAll();
        return proTypeList;
    }

    @RequestMapping(value = "/protype/set", method = RequestMethod.GET)
    public int setRecord(
        @RequestParam(value="id", required=true) Integer id,
        @RequestParam(value="value", required=true) Integer value,
        HttpServletResponse response
    ) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        int num = proTypeRepository.setProType(id, value);
        return num;
    }
}
