import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.ArrayList;

/**
 * Created by User on 16.02.2018.
 */

class TrixRobot {

    /**
     * Motors
     * 0 -> FrontRight
     * 1 -> RearLeft
     * 2 -> FrontLeft
     * 3 -> RearRight
     */
    private  static DcMotor[] motors = new DcMotor[4];
    private static DcMotor pulley_motor = null;
    private  LinearOpMode opMode;
    private  static Telemetry telemetry;

    TrixRobot(LinearOpMode opMode, Telemetry telemetry) {
        this.opMode = opMode;
        this.telemetry = telemetry;
        init();
    }

    private void init() {
        for (int i = 0; i < 4; i++) {
            motors[i] = opMode.hardwareMap.get(DcMotor.class, Integer.toString(i));
        }

        pulley_motor = opMode.hardwareMap.get(DcMotor.class, "pulley_motor");

        opMode.waitForStart();
    }

    static DcMotor[] getMotors() {
        return motors;
    }

    LinearOpMode getOpMode() {
        return opMode;
    }

    static Telemetry getTelemetry() {
        return telemetry;
    }

    static DcMotor getPulley_motor(){
        return pulley_motor;
    }

}
