package com.apj.platform.auth.controllers.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParsedToken {
    private String username;
}
