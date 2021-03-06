package org.usfirst.frc.team1332.robot.commands;

import org.usfirst.frc.team1332.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RobotServo extends Command {
	boolean forward = true;

    public RobotServo() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double orientation = 1.0;
    	
    	if (!forward){
    		orientation = orientation * -1;
    	
    	}
    	
    	RobotMap.servo.set(orientation);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
