package com.example.demo.business;

import lombok.Data;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;

//@Data
public class BaseBusiness {
    @Autowired
    protected MapperFacade mapper;
}
