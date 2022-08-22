package com.tucker.framework.ioc.entity;

/**
 * @author tonyc
 */
public class Robot {
    private Hand hand;

    private Mouth mouth;

    public Robot() {
    }

    public void start() {
        hand.WaveHand();
        mouth.speak();
    }
}
