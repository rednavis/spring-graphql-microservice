package com.rednavis.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.rednavis.core.model.EmployeeEntity;
import com.rednavis.employee.service.EmployeeService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.NameType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.BulkOperations.BulkMode;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
//@GraphQLTest
@ActiveProfiles("test")
public class EmpolyeeGraphQlTest extends AbstractMongoContainer {

  private static final MockNeat MOCK_NEAT = MockNeat.threadLocal();

  @Autowired
  private GraphQLTestTemplate graphQlTestTemplate;
  @Autowired
  private EmployeeService employeeService;

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
    BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkMode.UNORDERED, EmployeeEntity.class);
    bulkOperations.insert(employeeEntityList);
    bulkOperations.execute();
  }

  @Test
  public void testFindAll() {
    assertEquals(100, employeeService.findAll().size());
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
