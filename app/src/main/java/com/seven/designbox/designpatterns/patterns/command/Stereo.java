package com.seven.designbox.designpatterns.patterns.command;

import static com.seven.designbox.designpatterns.patterns.command.CommandState.State.*;

public class Stereo extends CommandTarget {

    public void start() {
        mState.setStereoState(STATE_ON);
        update(mState);
    }

    public void stop() {
        mState.setStereoState(STATE_OFF);
        update(mState);
    }
}
