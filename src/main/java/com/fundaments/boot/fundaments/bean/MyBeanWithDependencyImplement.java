package com.fundaments.boot.fundaments.bean;

import com.fundaments.boot.fundaments.utils.ImportanceLevel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private final Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    private final MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public String ipo(Enum level) {
        LOGGER.info("Server prepared for create INSTANCE IPO");
        LOGGER.debug("Getting speculation value: " + level);
        return " with initial value ipo for share: " + Math.random()  + " and expected level of speculation: " + myOperation.importance(level);
    }
}
