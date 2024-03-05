package com.sanctityofthelord.souldashboard.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
//@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "constants")
public class ApplicationProperties {

    private List<AppUser> appUserList;

    public List<AppUser> getAppUserList() {
        return appUserList;
    }

    public void setAppUserList(List<AppUser> appUserList) {
        this.appUserList = appUserList;
    }
}
