package com.rednavis.department;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class DepartmentApplicationTest {

  @Test
  public void simpleTest() {
    assertEquals(1, 1);
  }
}