package com.seven.designbox.designpatterns.patterns.command;

import static com.seven.designbox.designpatterns.patterns.command.CommandState.State.*;

public class Fan extends CommandTarget {

    public void turnOn() {
        mState.setFanState(STATE_ON);
        update(mState);
    }

    public void turnOff() {
        mState.setFanState(STATE_OFF);
        update(mState);
    }
}
