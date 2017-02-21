package org.usfirst.frc.team1332.robot.subsystems;

import org.usfirst.frc.team1332.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class lift extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void liftRobot (){
    	RobotMap.liftvictor.set(.7);
    }
    
    public void lowerRobot (){
    	RobotMap.liftvictor.set(-.7);
    }
    public void stopMotor(){
    	RobotMap.liftvictor.set(0);
    }
}

