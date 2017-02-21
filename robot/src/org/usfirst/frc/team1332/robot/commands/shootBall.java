package org.usfirst.frc.team1332.robot.commands;

import org.usfirst.frc.team1332.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class shootBall extends Command {

    public shootBall() {
    
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.ballShooter2();
    	Robot.shooter.ballShooter3();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
