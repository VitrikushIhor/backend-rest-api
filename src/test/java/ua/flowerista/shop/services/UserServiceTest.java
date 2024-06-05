package ua.flowerista.shop.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import ua.flowerista.shop.config.PostgresTestProfileJPAConfig;
import ua.flowerista.shop.mappers.AddressMapper;
import ua.flowerista.shop.mappers.BouquetMapper;
import ua.flowerista.shop.mappers.UserMapper;
import ua.flowerista.shop.models.Bouquet;
import ua.flowerista.shop.models.user.User;
import ua.flowerista.shop.repositories.BouquetRepository;
import ua.flowerista.shop.repositories.UserRepository;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestPropertySource(properties = {"spring.jpa.hibernate.ddl-auto=create"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
@SpringBootTest(classes = {UserService.class, UserRepository.class, PostgresTestProfileJPAConfig.class})
class UserServiceTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            DockerImageName.parse("postgres:latest"));

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @MockBean
    private UserMapper mapper;
    @MockBean
    private AddressMapper addressMapper;
    @MockBean
    private BouquetMapper bouquetMapper;
    @MockBean
    private AuthenticationManager authenticationManager;
    @MockBean
    private PasswordEncoder passwordEncoder;


    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BouquetRepository bouquetRepository;

    @BeforeAll
    static void setUpAll() {
        postgres.start();
    }

    @AfterAll
    static void tearDownAll() {
        postgres.stop();
    }

}
