// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static int elevatorLeftMotor = 5;
    public static int elevatorRightMotor = 6;

    public static int elevatorTopLimitSwitch = 7;
    public static int elevatorBottomLimitSwitch = 8;

    public static int driveTrainFrontLeftMotor = 0;
    public static int driveTrainBackLeftMotor = 1;
    public static int driveTrainFrontRightMotor = 2;
    public static int driveTrainBackRightMotor = 3;

    static double elevatorSpeed = 1;
    public static double getElevatorSpeed() {
        return Math.max(0d, Math.min(1d, elevatorSpeed));
    }

	public static double shooterSpeed = 0.75d;

	public static int shooterTopMotor = 9;
	public static int shooterLeftMotor = 10;
	public static int shooterBottomMotor = 11;
	public static int shooterRightMotor = 12;
	
	//from hermes github
    public enum Axes {
		LEFT_STICK_X(0), LEFT_STICK_Y(4), LEFT_TRIGGER(2), RIGHT_TRIGGER(3), RIGHT_STICK_X(1), RIGHT_STICK_Y(5);

		private final int value;

		Axes(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	public enum Buttons {
		A_BUTTON(1), B_BUTTON(2), X_BUTTON(3), Y_BUTTON(4), LEFT_BUMPER(5), RIGHT_BUMPER(6), BACK_BUTTON(
				7), START_BUTTON(8), LEFT_STICK(9), RIGHT_STICK(10);

		private final int value;

		private Buttons(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

    }   
    public static final double DEADZONE_VALUE = 0.01;
	public static final int NUMBER_OF_CONTROLLERS = 2;
}
