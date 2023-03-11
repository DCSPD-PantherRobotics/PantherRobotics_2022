package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import utils.Toggle;

@TeleOp
public class Setup extends OpMode {
    DcMotor pull;
    Servo latch;
    double servoPos = 0;
    double servoStep = 0.05;

    Toggle DpadUp = new Toggle();
    Toggle DpadDown = new Toggle();

    @Override
    public void init() {
        pull = hardwareMap.get(DcMotor.class, "pull");
        latch = hardwareMap.get(Servo.class, "latch");
        latch.getController().pwmEnable();
        latch.setDirection(Servo.Direction.FORWARD);
    }

    @Override
    public void loop() {
        if(DpadUp.update(gamepad1.dpad_up)) {
            servoPos += servoStep;
            latch.setPosition(servoPos);
        }
        else if(DpadDown.update(gamepad1.dpad_down)) {
            servoPos -= servoStep;
            latch.setPosition(servoPos);
        }
        telemetry.addData("Servo position: ", latch.getPosition());
    }
}
