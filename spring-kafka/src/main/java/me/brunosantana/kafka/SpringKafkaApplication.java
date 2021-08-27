package me.brunosantana.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

//Exemplo baseado em:
//https://www.baeldung.com/spring-kafka
//https://github.com/eugenp/tutorials/tree/master/spring-kafka

//Sobre CommandLineRunner:
//https://receitasdecodigo.com.br/spring-boot/spring-boot-usando-applicationrunner-e-commandlinerunner
//https://jhooq.com/commandlinerunner-spring-boot/

//Para subir o Kafka via Docker e criar o tópico:
//https://github.com/brunosantanati/docker/blob/main/meus-exemplos/kafka/anotacoes-kafka.txt

@SpringBootApplication
public class SpringKafkaApplication implements CommandLineRunner {

	@Value("${kafka.topic}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		sendMessage("Minha mensagem");
	}

	public void sendMessage(String msg) {
		kafkaTemplate.send(topicName, msg);
	}
}
