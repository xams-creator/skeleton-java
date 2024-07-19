package com.xams.skeleton.server;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TestCommand {

    private Long dashboardId;

    private Integer generateToken;

    private Long expireAt;

}
