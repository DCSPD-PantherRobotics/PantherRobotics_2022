package org.firstinspires.ftc.teamcode;

import utils.Toggle;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class SpinUp extends OpMode {
    DcMotor leftF;
    DcMotor rightF;
    DcMotor leftB;
    DcMotor rightB;
    double speed;

    @Override
    public void init() {
        leftF = hardwareMap.get(DcMotor.class, "leftFront");
        rightF = hardwareMap.get(DcMotor.class, "rightFront");
        leftB = hardwareMap.get(DcMotor.class, "leftBack");
        rightB = hardwareMap.get(DcMotor.class, "rightBack");

        leftF.setDirection(DcMotor.Direction.FORWARD);
        rightF.setDirection(DcMotor.Direction.FORWARD);
        rightB.setDirection(DcMotor.Direction.FORWARD);
        leftB.setDirection(DcMotorSimple.Direction.FORWARD);

        speed = 7;
    }

    @Override
    public void loop() {
        leftF.setPower(gamepad1.right_stick_x + gamepad1.left_stick_x + (-gamepad1.left_stick_y));
        leftB.setPower(gamepad1.right_stick_x - gamepad1.left_stick_x + (-gamepad1.left_stick_y));
        rightB.setPower(gamepad1.right_stick_x + gamepad1.left_stick_x - (-gamepad1.left_stick_y));
        rightF.setPower(gamepad1.right_stick_x - gamepad1.left_stick_x - (-gamepad1.left_stick_y));
    }
}
