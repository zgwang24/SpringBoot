package com.sain.controller;

import com.sain.dao.AdminRepository;
import com.sain.model.Admin;
import com.sain.model.Salesman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by zgwang on 6/20 0020.
 */
@RestController
public class AdminController {
    @Autowired
    AdminRepository adminRepository;

    @RequestMapping(value = "/verify/admin", method = RequestMethod.GET)
    public List<Admin> verifyAdmin(
            @RequestParam(value="name", required=true) String name,
            @RequestParam(value="pass", required=true) String pass,
            HttpServletResponse response
    ) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Admin> adminList = adminRepository.verify(name,pass);
        return adminList;

    }
}
