// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.WristSubsystem;

public class ArmUpCmd extends Command {
  ArmSubsystem m_armSubsystem;
  WristSubsystem m_wristSubsystem;
  ShooterSubsystem m_shooterSubsystem;

  public ArmUpCmd(
      ArmSubsystem armSubsystem,
      WristSubsystem wristSubsystem,
      ShooterSubsystem shooterSubsystem
  ) {
    m_armSubsystem = armSubsystem;
    m_wristSubsystem = wristSubsystem;
    m_shooterSubsystem = shooterSubsystem;
    addRequirements(m_armSubsystem, m_wristSubsystem, m_shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_armSubsystem.pos(Constants.kArmAmp);
    m_wristSubsystem.pos(Constants.kWristAmp);
    m_shooterSubsystem.spinSlow();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
