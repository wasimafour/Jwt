package com.app.Jwt.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppData {

    private String appName;
    private String appId;
    private Date validTill;
    private String[] ownerEmails;
}
