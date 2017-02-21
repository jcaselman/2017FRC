
package org.usfirst.frc.team1332.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1332.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    public static final shooter shooter = new shooter();
    public static final lift lift = new lift();
    public static final Pickup pickup = new Pickup();
	
	public static OI oi;
	public static Robot robot;	

	ADXRS450_Gyro gyro;
	PowerDistributionPanel pdp;
	BuiltInAccelerometer bia;
	Preferences pref;
	UsbCamera camera;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {	
		robot = this;
		oi = new OI();

		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		
		gyro = new ADXRS450_Gyro();
		gyro.calibrate();
		pdp = new PowerDistributionPanel(1);
		bia = new BuiltInAccelerometer();
		
		pref = Preferences.getInstance();
		pref.putString("Test", "string");
		
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(640, 360);
		//camera.setExposureManual(100);
		//camera.setExposureAuto();
		
		
		
		
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Heading", gyro.getAngle());
		SmartDashboard.putNumber("PDP Voltage", pdp.getVoltage());
		SmartDashboard.putNumber("PDP Current", pdp.getTotalCurrent());
		SmartDashboard.putNumber("PDP Temperature", pdp.getTemperature());
		SmartDashboard.putNumber("PDP Watts", pdp.getTotalPower());
		SmartDashboard.putNumber("PDP Channel 0", pdp.getCurrent(0));
		SmartDashboard.putNumber("PDP Channel 1", pdp.getCurrent(1));
		SmartDashboard.putNumber("PDP Channel 2", pdp.getCurrent(2));
		SmartDashboard.putNumber("PDP Channel 3", pdp.getCurrent(3));
		SmartDashboard.putNumber("BIA X", bia.getX());
		SmartDashboard.putNumber("BIA Y", bia.getY());
		SmartDashboard.putNumber("BIA Z", bia.getZ());
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	
		SmartDashboard.putNumber("Heading", gyro.getAngle());

		double yAxis = oi.opPad.getY();
		double xAxis = oi.opPad.getX();
		double zAxis = oi.opPad.getZ();
		
		double resultFL = (yAxis + -1 * xAxis + -1 * zAxis)/3;
		double resultFR = (yAxis + xAxis + zAxis)/3;
		double resultRL = (yAxis + xAxis + -1 * zAxis)/3;
		double resultRR = (yAxis + -1 * xAxis + zAxis)/3;

		RobotMap.talonFL.set(resultFL);
		RobotMap.talonFR.set((-1 * resultFR));
		RobotMap.talonRL.set((-1 * resultRL));
		RobotMap.talonRR.set(resultRR);

	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}

}
