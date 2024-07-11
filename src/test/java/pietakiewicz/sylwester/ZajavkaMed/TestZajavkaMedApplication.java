package pietakiewicz.sylwester.ZajavkaMed;

import org.springframework.boot.SpringApplication;

public class TestZajavkaMedApplication {

	public static void main(String[] args) {
		SpringApplication.from(ZajavkaMedApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
