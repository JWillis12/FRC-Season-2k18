/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1398.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.MecanumDrive;


public class Robot extends IterativeRobot {
	private static final int kFrontLeftChannel = 2;
	private static final int kRearLeftChannel = 3;
	private static final int kFrontRightChannel = 1;
	private static final int kRearRightChannel = 0;

	private static final int kJoystickChannel = 0;

	private MecanumDrive m_robotDrive;
	private Joystick driveStick;

	@Override
	public void robotInit() {
		VictorSP frontLeft = new VictorSP(kFrontLeftChannel);
		VictorSP rearLeft = new VictorSP(kRearLeftChannel);
		VictorSP frontRight = new VictorSP(kFrontRightChannel);
		VictorSP rearRight = new VictorSP(kRearRightChannel);

		// Invert the left side motors.
		// You may need to change or remove this to match your robot.
		frontLeft.setInverted(false);
		rearLeft.setInverted(false);

		m_robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

		driveStick = new Joystick(kJoystickChannel);
	}

	@Override
	public void teleopPeriodic() {
		// Use the joystick X axis for lateral movement, Y axis for forward
		// movement, and Z axis for rotation.
		m_robotDrive.driveCartesian(driveStick.getX(), driveStick.getY(),
				driveStick.getZ(), 0.0 );
	}
}
