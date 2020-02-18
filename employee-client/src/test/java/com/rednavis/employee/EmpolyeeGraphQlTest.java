package com.rednavis.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rednavis.core.model.EmployeeEntity;
import com.rednavis.employee.service.EmployeeService;
import java.util.List;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.NameType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
//@GraphQLTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {EmpolyeeGraphQlTest.Initializer.class})
public class EmpolyeeGraphQlTest {

  @Container
  private static final MongoDbContainer MONGO_DB_CONTAINER = new MongoDbContainer();

  private static final MockNeat MOCK_NEAT = MockNeat.threadLocal();

  //@Autowired
  //private GraphQLTestTemplate graphQlTestTemplate;
  @Autowired
  private EmployeeService employeeService;
  @Autowired
  private MongoTemplate mongoTemplate;

  /**
   * init.
   */
  @BeforeEach
  public void init() {
    employeeService.deleteAll();

    List<EmployeeEntity> employeeEntityList = MOCK_NEAT.reflect(EmployeeEntity.class)
        .field("name", MOCK_NEAT.names().type(NameType.LAST_NAME))
        .field("age", MOCK_NEAT.ints().range(18, 50))
        .field("city", MOCK_NEAT.cities().capitals())
        .field("salary", MOCK_NEAT.ints().range(100, 1000))
        .list(100)
        .val();
    BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, EmployeeEntity.class);
    bulkOperations.insert(employeeEntityList);
    bulkOperations.execute();
  }

  @Test
  public void testFindAll() {
    assertTrue(MONGO_DB_CONTAINER.isRunning());
    assertEquals(100, employeeService.findAll().size());
  }

  static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      TestPropertyValues.of("spring.data.mongodb.port=" + MONGO_DB_CONTAINER.getPort())
          .applyTo(configurableApplicationContext.getEnvironment());
    }
  }
  //@Test
  //public void get_comments() throws IOException {
  //  GraphQLResponse response = graphQlTestTemplate.postForResource("graphql/findAll.graphql");
  //  assertNotNull(response);
  //  assertTrue(response.isOk());
  //  assertEquals("1", response.get("$.data.post.id"));
  //}

  //@Test
  //public void create_post() throws IOException {
  //  ObjectNode variables = new ObjectMapper().createObjectNode();
  //  variables.put("text", "lorem ipsum dolor sit amet");
  //  GraphQLResponse response = graphQlTestTemplate.perform("graphql/create-post.graphql", variables);
  //  assertNotNull(response);
  //  assertNotNull(response.get("$.data.createPost.id"));
  //}
}
