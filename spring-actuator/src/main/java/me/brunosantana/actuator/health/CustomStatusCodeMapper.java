package me.brunosantana.actuator.health;

import org.springframework.boot.actuate.health.HttpCodeStatusMapper;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class CustomStatusCodeMapper implements HttpCodeStatusMapper {

    @Override
    public int getStatusCode(Status status) {

        if (status == Status.DOWN) {
            return 501;
        }

        if (status == Status.OUT_OF_SERVICE) {
            return 501;
        }

        if (status == Status.UNKNOWN) {
            return 501;
        }

        return 200;
    }
}
