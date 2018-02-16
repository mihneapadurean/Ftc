import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by User on 16.02.2018.
 */
@TeleOp(name = "OpMode Test", group = "OpMode")
public class OpModeTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        new TrixRobotManual(this, telemetry, gamepad1, gamepad2);
    }

}
