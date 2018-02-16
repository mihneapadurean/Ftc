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


           moveMotorWithCm(32, pulley_motor, 0.4);

            double rear_left_power = g1.left_stick_y;
            int position = pulley_motor.getCurrentPosition();

            Telemetry telemetry = TrixRobot.getTelemetry();

            telemetry.addData("Encoder Position", position);
            telemetry.addData("Motor Speed", pulley_motor.getPower());
            telemetry.addData("Joystick", rear_left_power);
            telemetry.addData("is busy: ", pulley_motor.isBusy());
            telemetry.update();


        }
    }

    private void moveMotorWithCm(double cm, DcMotor motor, double tgt_speed){
        double ticksFor1Cm = 165.6;
        double ticks = cm * ticksFor1Cm;
        int intTicks = (int)(Math.ceil(ticks));
        motor.setTargetPosition(intTicks);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(tgt_speed);


    }

}
