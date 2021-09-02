package com.fundaments.boot.fundaments.component;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ComponentImplement implements ComponentDependency{
    @Override
    public String token() {
        return UUID.randomUUID().toString();
    }
}
