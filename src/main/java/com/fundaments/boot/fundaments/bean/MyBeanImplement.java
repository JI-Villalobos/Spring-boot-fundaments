package com.fundaments.boot.fundaments.bean;

import java.time.LocalDate;

public class MyBeanImplement implements MyBean{
    @Override
    public LocalDate to() {
        return LocalDate.now();
    }
}
