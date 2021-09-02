package com.fundaments.boot.fundaments.bean;

import java.time.LocalDate;

public class MyBean2Implement implements MyBean{
    @Override
    public LocalDate to() {
        return LocalDate.now().plusDays(10);
    }
}
