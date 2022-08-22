package com.tucker.framework.ioc;

import com.tucker.framework.ioc.core.JsonApplicationContext;
import com.tucker.framework.ioc.entity.Robot;

/**
 * @author tonyc
 */
public class Test {

    public static void main(String[] args) {
        JsonApplicationContext jsonApplicationContext =
                new JsonApplicationContext("application.json");
        jsonApplicationContext.init();
        Robot robot = (Robot) jsonApplicationContext.getBean("robot");
        robot.start();
    }
}
