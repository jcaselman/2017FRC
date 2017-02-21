package org.usfirst.frc.team1332.robot;

import org.usfirst.frc.team1332.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public JoystickButton shootBallB1;
    public JoystickButton feedBallB2;
    public JoystickButton liftRobotB3;
    public JoystickButton lowerRobotB4;
    public JoystickButton pickupBallB5;

    public Joystick opPad;
    public Joystick arcadeStick;

    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    Joystick stick;

    public OI() {
        stick = new Joystick(1);
        JoystickButton button = new JoystickButton(stick, 1);

        button.whenPressed(new RobotServo());
    }

    public Joystick getStick() {
        return stick;
    }

    {
        opPad = new Joystick(2);
        shootBallB1 = new JoystickButton(opPad, 6);
        shootBallB1.whileHeld(new shootBall());
        feedBallB2 = new JoystickButton(opPad, 5);
        feedBallB2.whileHeld(new feedBall());

        liftRobotB3 = new JoystickButton(opPad, 4);
        liftRobotB3.whileHeld(new liftRobot());

        lowerRobotB4 = new JoystickButton(opPad, 1);
        lowerRobotB4.whileHeld(new lowerRobot());

        pickupBallB5 = new JoystickButton(opPad, 3);
        pickupBallB5.whileHeld(new pickupBall());

    }

}