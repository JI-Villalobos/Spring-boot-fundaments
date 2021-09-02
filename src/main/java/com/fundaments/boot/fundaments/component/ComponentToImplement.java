package com.fundaments.boot.fundaments.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentToImplement implements ComponentDependency{
    @Override
    public String token() {
        return java.util.UUID.randomUUID().toString() + "srlkjds65654:645654:";
    }
}
