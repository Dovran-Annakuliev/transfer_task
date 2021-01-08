package ru.sberstart.transfer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import ru.sberstart.transfer.model.User;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransferApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetUsers() {
		ResponseEntity<List<User>> users = restTemplate.exchange(
			"http://localhost:" + port + "/users",
			HttpMethod.GET,
			null,
			new ParameterizedTypeReference<List<User>>() {
			});
		Assert.isTrue(!users.getBody().isEmpty(), "При корректном выполнении скрипта data.sql БД должны быть пользователи");
	}

}
