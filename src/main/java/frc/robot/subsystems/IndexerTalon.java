// This is a temp intake file as we don't have enough falcon's. Redo Indexer commands when we change back to Falcon's.
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class IndexerTalon  extends SubsystemBase {
    
    private final WPI_TalonSRX IndexerTalon = new WPI_TalonSRX(Constants.kClimber);

    public IndexerTalon() {

    }

    public void setIndexerSpeed(double indexerSpeed) {
        IndexerTalon.set(indexerSpeed);
    }
}
