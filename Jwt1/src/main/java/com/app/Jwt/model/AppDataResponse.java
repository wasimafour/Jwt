package com.app.Jwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppDataResponse {

    private String key;
    private String appName;
    private String appId;
    private Date validTill;
    private String ownerEmails;

}
