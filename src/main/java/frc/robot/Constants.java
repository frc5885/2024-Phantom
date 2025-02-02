package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;

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
  public static final int kClimberLeft = 56;
  public static final int kClimberRight = 55;

  // Arm Encoder Stuff
  public static final double kArmEncoderMax = 0.276;
  public static final double kArmEncoderMin = 0.096;
  // The rotation 2d will have to be changed to doubles when we know our setpoint
  public static final double kArmAmp = 0.273; //max -.03
  // public static final double kSetPoint = -0.1;
  public static final double kArmStow = 0.096; //min
  public static final double kArmPass = 0.19; //min + .8

  // Wrist Encoder Stuff
  // Angles with wrist relative to the arm at hardstop
  // Min to max 30 degrees
  // Max 0.315
  // Min  0.625
  // 1.03 worked for old tape
  public static final double kWristAngleCorrectionFactorClose = 1.015;
  public static final double kWristAngleCorrectionFactorFar = 1.015;
  public static final double kWristEncoderMax = 0.577; // Max
  public static final double kWristEncoderMin = 0.325; // Min
  public static final double kWristStow = 0.441; // Stow
  public static final double kWristPass = kWristStow; // Pass cross field
  public static final double kWristAmp = 0.376; // Amp
  // public static final double kWristSubwoofer = -0.5;
  public static final double kWristSubwoofer = 0.393;
  public static final double kWrist15 = 0.0;
  public static final double kWrist30 = 0.0;
  public static final double kWrist45 = 0.0;
  public static final double kWrist60 = 0.0;
  public static final double kWrist75 = 0.0;
  public static final double kWrist90 = 0.0;
  public static final double kWristEject = 0.0;

  // Climber Deadzones
  public static final double kOperatorRightDeadzone = 0.08;
  public static final double kOperatorLeftDeadzone = 0.08;
  public static final double kRightClimberMin = 0.0;
  public static final double kRightClimberMax = 200;
  public static final double kLeftClimberMin = 0.0;
  public static final double kLeftClimberMax = 180;

  // Driver Deadzones
  public static final double kDriverRightDeadzone = 0.06;
  public static final double kDriverLeftDeadzone = 0.06;

  // LED
  public static final int kLED = 9;
  public static final double kIntakeCurrentThreshold = 18.0;

  public static final double kPassDistanceClose = 5.0;
  public static final double kPassDistanceFar = 9.25;

  public static final double kShootSubwooferThreshold = 1.0;

  public static final double kShooterMinSpeed = -2800;

  // Pass target
  public static final Translation2d kPassTargetBlue = new Translation2d(1.0, 7.0);
  public static final Translation2d kPassTargetRed = new Translation2d(14.75, 7.0);

  // shooter distance thresholds
  public static final double kShootCloseThreshold = 3.3;
  public static final double kShootFarThreshold = 4.1;
}
