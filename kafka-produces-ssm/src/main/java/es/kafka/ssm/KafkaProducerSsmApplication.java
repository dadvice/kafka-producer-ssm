package es.kafka.ssm;

import es.kafka.ssm.bean.GreetingBean;
import es.kafka.ssm.config.KafkaProducerVars;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.UUID;

@Slf4j
@SpringBootApplication
public class KafkaProducerSsmApplication implements CommandLineRunner {

	@Autowired
	private KafkaTemplate<String, GreetingBean> kafkaTemplate;

	@Autowired
	private KafkaProducerVars kafkaVars;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerSsmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.info("Before publishing a GreetingBean");

		while (true) {

			String key = UUID.randomUUID().toString();
			GreetingBean body = GreetingBean.builder().message(kafkaVars.getMessage()).build();

			SendResult<String, GreetingBean> result =
					kafkaTemplate.send("topic-test", key, body).get();

			log.info("Partition: " + result.getRecordMetadata().partition());
			log.info("Topic: " + result.getRecordMetadata().topic());
			log.info("Offset: " + result.getRecordMetadata().offset());

			Thread.sleep(5000);
		}
	}
}
