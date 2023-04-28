package com.xiaohu.media_assets.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xiaohu
 * @date 2023/04/28/ 22:02
 * @description
 */
@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    @Value("endpoint")
    private String endpoint;

    @Value("access-key")
    private String accessKey;

    @Value("access-secret")
    private String accessSecret;

    @Value("bucket")
    private String bucket;
}
