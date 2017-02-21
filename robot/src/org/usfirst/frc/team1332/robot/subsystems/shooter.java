package org.usfirst.frc.team1332.robot.subsystems;

import org.usfirst.frc.team1332.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
     
    public void ballShooter2(){
    	RobotMap.shootervictor1.set(1);
    }
    public void ballShooter3(){
    	RobotMap.shootervictor2.set(1);
    }
  
    public void stopMotor(){
    	RobotMap.shootervictor1.set(0);
    	RobotMap.shootervictor2.set(0);
    	RobotMap.feedervictor3.set(0);
    	
    }

	public void feedBall() {
		// TODO Auto-generated method stub
		RobotMap.feedervictor3.set(1);
	}
}

