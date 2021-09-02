package com.fundaments.boot.fundaments.bean;

public class MyOperationImplement implements MyOperation{
    @Override
    public String importance(Enum level) {
        return "→" + level;
    }
}
