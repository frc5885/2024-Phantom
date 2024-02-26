// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.PoseEstimatorSubsystem;

import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.AutoConstants.PoseEstimatorConstants;
import frc.robot.base.modules.swerve.SwerveConstants;
import frc.robot.base.subsystems.swerve.SwerveDriveSubsystem;
import java.util.function.Supplier;
import org.littletonrobotics.junction.Logger;

import org.photonvision.EstimatedRobotPose;

// This object is created in the WCRobot class
public class SwervePoseEstimator extends SubsystemBase {
  private final Supplier<Rotation2d> m_rotationSupplier;
  private final Supplier<SwerveModulePosition[]> m_swerveModulePositionSupplier;

  private final SwerveDrivePoseEstimator m_poseEstimator;

  private final SwerveDriveSubsystem m_swerveDrive;

  private final PhotonVisionSystem m_photonVision;

  /** Creates a new TankDrivePoseEstimator. */
  public SwervePoseEstimator(SwerveDriveSubsystem swerveDrive, PhotonVisionSystem photonVision) {

    m_rotationSupplier = swerveDrive::getRotation2d;
    m_swerveModulePositionSupplier = swerveDrive::getModulePositions;

    m_poseEstimator =
        new SwerveDrivePoseEstimator(
            SwerveConstants.kDriveKinematics,
            m_rotationSupplier.get(),
            m_swerveModulePositionSupplier.get(),
            new Pose2d(),
            PoseEstimatorConstants.kEncoderMeasurementStdDevs,
            PoseEstimatorConstants.kVisionMeasurementStdDevs);

    m_swerveDrive = swerveDrive;

    m_photonVision = photonVision;

    reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    // Update the WPI pose estimator with the latest rotation and position measurements from swerve system
    m_poseEstimator.update(m_rotationSupplier.get(), m_swerveModulePositionSupplier.get());
    Logger.recordOutput("SwervePoseEstimator/estimatedPose", m_poseEstimator.getEstimatedPosition());


    // Update the WPI pose estimator with the latest vision measurements from photon vision if they are present
    if (m_photonVision.getEstimatedGlobalPose(m_poseEstimator.getEstimatedPosition()).isPresent()) {
      
      // have to call .get() to get the value from the optional
      EstimatedRobotPose estimatedVisionPose =
          m_photonVision.getEstimatedGlobalPose(m_poseEstimator.getEstimatedPosition()).get();

      // actually add the vision measurement
      m_poseEstimator.addVisionMeasurement(
              estimatedVisionPose.estimatedPose.toPose2d(), estimatedVisionPose.timestampSeconds);

      Logger.recordOutput("SwervePoseEstimator/visionEstimatedPose", estimatedVisionPose.estimatedPose.toPose2d());
      Logger.recordOutput("SwervePoseEstimator/visionEstimatedPose3D", estimatedVisionPose.estimatedPose);

    }
  }

  public void addVisionPose(Pose2d pose, double timestamp) {
    m_poseEstimator.addVisionMeasurement(pose, timestamp);
  }

  public Pose2d getPose() {
    return m_poseEstimator.getEstimatedPosition();
  }

  public void reset(Pose2d newPose) {
    m_swerveDrive.resetGyro();
    m_poseEstimator.resetPosition(
        m_rotationSupplier.get(), m_swerveModulePositionSupplier.get(), newPose);
  }

  public void reset() {
    reset(new Pose2d(0, 0, new Rotation2d()));
  }
}
