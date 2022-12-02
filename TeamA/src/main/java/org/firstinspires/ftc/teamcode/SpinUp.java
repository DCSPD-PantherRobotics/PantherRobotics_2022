package org.firstinspires.ftc.teamcode;

import utils.Toggle;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class SpinUp extends LinearOpMode {

    private DcMotor leftB;
    private DcMotor rightF;
    private DcMotor leftF;
    private DcMotor rightB;

    public void runOpMode() {

        leftF = hardwareMap.get(DcMotor.class, "leftFront");
        rightF = hardwareMap.get(DcMotor.class, "rightFront");
        leftB = hardwareMap.get(DcMotor.class, "leftBack");
        rightB = hardwareMap.get(DcMotor.class, "rightBack");

        leftF.setDirection(DcMotor.Direction.FORWARD);
        rightF.setDirection(DcMotor.Direction.FORWARD);
        rightB.setDirection(DcMotor.Direction.FORWARD);
        leftB.setDirection(DcMotorSimple.Direction.FORWARD);

        double speedAjust = 7;
        waitForStart();
//        runtime.reset();

        while (opModeIsActive()) {

            leftF.setPower(gamepad1.right_stick_x + gamepad1.left_stick_x + (-gamepad1.left_stick_y));
            leftB.setPower(gamepad1.right_stick_x - gamepad1.left_stick_x + (-gamepad1.left_stick_y));
            rightB.setPower(gamepad1.right_stick_x + gamepad1.left_stick_x - (-gamepad1.left_stick_y));
            rightF.setPower(gamepad1.right_stick_x - gamepad1.left_stick_x - (-gamepad1.left_stick_y));



//                if (slowToggle.getState()) {
//                    driveMult = 0.5;
//                } else {
//                    driveMult = 0.1;
//                }

        }
    }
}