package org.jointheleague.iaroc;

import android.os.SystemClock;

import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import org.wintrisstech.irobot.ioio.IRobotCreateAdapter;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;
import org.jointheleague.iaroc.sensors.UltraSonicSensors;

public class Brain extends IRobotCreateAdapter {
    private final Dashboard dashboard;
    public UltraSonicSensors sonar;

    public Brain(IOIO ioio, IRobotCreateInterface create, Dashboard dashboard)
            throws ConnectionLostException {
        super(create);
        sonar = new UltraSonicSensors(ioio);
        this.dashboard = dashboard;
    }

    /* This method is executed when the robot first starts up. */
    public void initialize() throws ConnectionLostException {
        dashboard.log("Hello! I'm a Clever Robot!");
        //what would you like me to do, Clever Human?
//driveDirect(100, 100);

        //makeSquare();
driveDirect(-100, 100);
    }

    private void makeSquare() throws ConnectionLostException {
        for(int i = 0; i<4; i++){
            driveDirect(100, 100);
            SystemClock.sleep(3000);
            driveDirect(-150, 145);
            SystemClock.sleep(2200);
            driveDirect(0,0);
        }
    }
    int totalAngle = 0;
    /* This method is called repeatedly. */
    public void loop() throws ConnectionLostException {
        readSensors(SENSORS_ANGLE);
        int angle = getAngle();
        totalAngle=angle+totalAngle;
        dashboard.log(""+totalAngle);
    }

}