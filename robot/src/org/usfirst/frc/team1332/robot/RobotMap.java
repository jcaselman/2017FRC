package org.usfirst.frc.team1332.robot;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TalonSRX;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.CANSpeedController;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static int servoPort = 0;
	public static Servo servo = new Servo(servoPort);
	
	public static boolean forward = true;
	
	public static int canTalonFR = 12;
	public static int canTalonFL = 11;
	public static int canTalonRL = 14;
	public static int canTalonRR = 13;
	
	public static CANSpeedController talonFR = new CANTalon(canTalonFR);	
	public static CANSpeedController talonFL = new CANTalon(canTalonFL);
	
	public static CANSpeedController talonRL = new CANTalon(canTalonRL);
	public static CANSpeedController talonRR = new CANTalon(canTalonRR);
	
	
}
