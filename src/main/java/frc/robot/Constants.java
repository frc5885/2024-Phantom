package frc.robot;

import edu.wpi.first.math.geometry.Rotation2d;

public final class Constants {
  // Intake Motor IDs
  public static final int kIntakeLeft = 31;
  public static final int kIntakeRight = 30;
  public static final int kBeambreak = 6;
  public static final int kFeeder = 40;
  public static final int kShooterTop = 50;
  public static final int kShooterBottom = 51;
  public static final int kArm = 60;
  public static final int kWrist = 61;
  public static final int kClimberLeft = 55;
  public static final int kClimberRight = 56;

  // Arm Encoder Stuff
  public static final double kArmEncoderMax = Math.PI / 2;
  public static final double kArmEncoderMin = 0.0;
  // The rotation 2d will have to be changed to doubles when we know our setpoint
  public static final Rotation2d kArmAmp = Rotation2d.fromRadians(kArmEncoderMax);
  public static final double kSetPoint = 0.2;
  public static final Rotation2d kArmStow = Rotation2d.fromRadians(kArmEncoderMin);

  // Wrist Encoder Stuff
  public static final double kWristEncoderMax = 0.762;
  public static final double kWristEncoderMin = -1.677;
  public static final double kWristStow = 0.168;
  public static final double kWristAmp = 0.762;

  // Climber Deadzones
  public static final double kOperatorRightDeadzone = 0.02;
  public static final double kOperatorLeftDeadzone = 0.02;
  // public static final double kRightClimberMin =
  // pulbic static final double kRightClimberMax =
  // public static final double kLeftClimberMin =
  // public static final doubel kLeftClimberMax =

  public static final String kCameraName = "Lenovo_FHD_Webcam";
  public static final double kCameraPositionX = 0.5;
  public static final double kCameraPositonY = 0.5;
  public static final double kCameraPositionZ = 0.5;
  public static final double kCameraRoll = 0.0;
  public static final double kCameraPitch = 0.0;
  public static final double kCameraYaw = 0.0;
}
