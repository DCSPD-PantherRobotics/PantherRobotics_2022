package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class SpinUp extends OpMode {
    // Driving
    DcMotor M_leftF;
    DcMotor M_rightF;
    DcMotor M_leftB;
    DcMotor M_rightB;

    // Launching disks
    Servo S_launch;
    DcMotor M_reload;

    // Misc.
    double speed;

    @Override
    public void init() {
        // Assign motors
        M_leftF = hardwareMap.get(DcMotor.class, "leftFront");
        M_rightF = hardwareMap.get(DcMotor.class, "rightFront");
        M_leftB = hardwareMap.get(DcMotor.class, "leftBack");
        M_rightB = hardwareMap.get(DcMotor.class, "rightBack");

        // Set initial directions
        M_leftF.setDirection(DcMotor.Direction.FORWARD);
        M_rightF.setDirection(DcMotor.Direction.FORWARD);
        M_rightB.setDirection(DcMotor.Direction.FORWARD);
        M_leftB.setDirection(DcMotor.Direction.FORWARD);

        S_launch.getController().pwmEnable();

        // Misc.
        speed = 7;
    }

    private void reload() {
        // Reloads the crossbow
    }

    private void shoot() {
        // Shoots the disk
        S_launch.setPosition(0);
    }

    @Override
    public void loop() {
        M_leftF.setPower(gamepad1.right_stick_x + gamepad1.left_stick_x + (-gamepad1.left_stick_y));
        M_leftB.setPower(gamepad1.right_stick_x - gamepad1.left_stick_x + (-gamepad1.left_stick_y));
        M_rightB.setPower(gamepad1.right_stick_x + gamepad1.left_stick_x - (-gamepad1.left_stick_y));
        M_rightF.setPower(gamepad1.right_stick_x - gamepad1.left_stick_x - (-gamepad1.left_stick_y));
    }
}
