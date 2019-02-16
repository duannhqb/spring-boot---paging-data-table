package com.prographer.pagination.controller;


import com.prographer.pagination.model.User;
import com.prographer.pagination.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdvertiserController {
    @Autowired
    AdvertiserRepository advertiserRepository;

    @RequestMapping
    private ModelAndView index(@RequestParam(defaultValue = "0", required = false) int page) {
        ModelAndView mav = new ModelAndView("/list");
        PageRequest pageRequest = new PageRequest(page,10);
        mav.addObject("pages", advertiserRepository.findAll(pageRequest));
        return mav;
    }
}
