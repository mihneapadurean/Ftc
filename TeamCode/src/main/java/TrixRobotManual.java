import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by User on 16.02.2018.
 */

class TrixRobotManual extends TrixRobot {

    private Gamepad g1;
    private Gamepad g2;

    TrixRobotManual(LinearOpMode opMode, Telemetry telemetry, Gamepad gamepad1, Gamepad gamepad2) {
        super(opMode, telemetry);
        g1 = gamepad1;
        g2 = gamepad2;
        initialize();
        run();
    }

    private void initialize() {

    }

    private void run() {
        while (getOpMode().opModeIsActive()) {
            DcMotor[] motors = TrixRobot.getMotors();

            DcMotor pulley_motor = TrixRobot.getPulley_motor();
            //pulley_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


            double rear_left_power = g1.left_stick_y;
            int position = pulley_motor.getCurrentPosition();

            pulley_motor.setPower(0.5);

            Telemetry telemetry = TrixRobot.getTelemetry();

            telemetry.addData("Encoder Position", position);
            telemetry.addData("Motor Speed", pulley_motor.getPower());
            telemetry.addData("Joystick", rear_left_power);
            telemetry.update();


        }
    }

}
