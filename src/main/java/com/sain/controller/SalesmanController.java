package com.sain.controller;

import com.sain.dao.ProTypeRepository;
import com.sain.dao.SalesmanRepository;
import com.sain.model.ProType;
import com.sain.model.Salesman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class SalesmanController {
    @Autowired
    SalesmanRepository salesmanRepository;

    @RequestMapping(value = "/verify/salesman", method = RequestMethod.GET)
    public List<Salesman> verify(
        @RequestParam(value="name", required=true) String name,
        @RequestParam(value="pass", required=true) String pass,
        HttpServletResponse response
    ) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Salesman> salesmanList = salesmanRepository.verify(name,pass);
        return salesmanList;
    }
}
