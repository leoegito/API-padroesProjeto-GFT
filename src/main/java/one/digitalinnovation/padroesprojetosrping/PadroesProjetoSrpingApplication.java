package one.digitalinnovation.padroesprojetosrping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PadroesProjetoSrpingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesProjetoSrpingApplication.class, args);
	}

}
