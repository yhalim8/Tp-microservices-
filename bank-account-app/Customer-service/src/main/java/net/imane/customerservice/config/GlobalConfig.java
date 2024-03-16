package net.imane.customerservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix = "global.params")
@RefreshScope
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class GlobalConfig {
    private int p1;
    private int p2;
}
