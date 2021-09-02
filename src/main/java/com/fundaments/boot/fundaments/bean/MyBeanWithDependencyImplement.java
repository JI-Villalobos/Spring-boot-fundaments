package com.fundaments.boot.fundaments.bean;

import com.fundaments.boot.fundaments.utils.ImportanceLevel;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private final MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public String ipo(Enum level) {
        return " with initial value ipo for share: " + Math.random()  + " and expected level of speculation: " + myOperation.importance(level);
    }
}
