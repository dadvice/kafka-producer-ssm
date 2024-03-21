package es.kafka.ssm.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class KafkaProducerVars {

    @Value("${bootstrap-server}")
    private String bootstrapServer;
    @Value("${key-serializer}")
    private String keySerializer;
    @Value("${value-serializer}")
    private String valueSerializer;
    @Value("${message:Hello Wolrd}")
    private String message;
}
