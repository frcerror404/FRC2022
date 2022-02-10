// Key subsystems such as the main subsystem file and constants.
package frc.robot.subsystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

// import Talon (Falcon 500 motor controllers have talons in them.) libraries.
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;


public class Drivebase extends SubsystemBase {
  // Left Master and Save motor controller. 
  private final WPI_TalonFX LeftMaster = new WPI_TalonFX(Constants.klDT1);
  private final WPI_TalonFX LeftSlave = new WPI_TalonFX(Constants.klDT2);

  // Right Master and Slave motor controller.
  private final WPI_TalonFX RightMaster = new WPI_TalonFX(Constants.krDT1);
  private final WPI_TalonFX RightSlave = new WPI_TalonFX(Constants.krDT2);

  private final DifferentialDrive drivetrain = new DifferentialDrive(LeftMaster, RightMaster);


  public Drivebase() {
    setRightMasterDefaults();
    setLeftMasterDefaults();
    setrightSlaveDefaults();
    setleftSlaveDefaults();
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void manualControl(double rawAxis, double rawAxis2, boolean button) {
    
    if(Constants.isCurvatureDrive) {
      drivetrain.curvatureDrive(rawAxis, rawAxis2, button);
    } else {
      drivetrain.tankDrive(-rawAxis, -rawAxis2);
      //System.out.println(String.format("Drivetrain Speed: %f %f", -rawAxis, -rawAxis2));
    }
    
  }

    // Reset Motor Controllers and set Limits/Ramp Rate
    private void setLeftMasterDefaults() {
      LeftMaster.configFactoryDefault();
      LeftMaster.setNeutralMode(NeutralMode.Coast);
      LeftMaster.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(false, 50, 55, 1.0));
      LeftMaster.configOpenloopRamp(.25);
    }

    private void setleftSlaveDefaults() {
      LeftSlave.configFactoryDefault();
      LeftSlave.setNeutralMode(NeutralMode.Coast);
      LeftSlave.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(false, 50, 55, 1.0));
      LeftSlave.configOpenloopRamp(.25);
      LeftSlave.follow(LeftMaster);
      //LeftSlave.setInverted(true);
    }

    private void setRightMasterDefaults() {
      RightMaster.configFactoryDefault();
      RightMaster.setNeutralMode(NeutralMode.Coast);
      RightMaster.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(false, 50, 55, 1.0));
      RightMaster.configOpenloopRamp(.25);
      RightMaster.setInverted(InvertType.InvertMotorOutput);
    }
   
    private void setrightSlaveDefaults() {
      RightSlave.configFactoryDefault();
      RightSlave.setNeutralMode(NeutralMode.Coast);
      RightSlave.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(false, 50, 55, 1.0));
      RightSlave.configOpenloopRamp(.25);
      RightSlave.follow(RightMaster);
      RightSlave.setInverted(InvertType.InvertMotorOutput);

  }
}
