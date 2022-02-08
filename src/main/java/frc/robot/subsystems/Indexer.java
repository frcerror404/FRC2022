package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Indexer extends SubsystemBase {
    
    private final WPI_TalonFX Indexer = new WPI_TalonFX(Constants.kIndexer);

    public Indexer() {

    }

    public void setIndexerSpeed(double indexerSpeed) {
        Indexer.set(indexerSpeed);
    }
}
