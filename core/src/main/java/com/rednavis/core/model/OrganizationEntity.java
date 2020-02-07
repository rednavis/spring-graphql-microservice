package com.rednavis.core.model;

import io.github.kaiso.relmongo.annotation.CascadeType;
import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.JoinProperty;
import io.github.kaiso.relmongo.annotation.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "organization")
public class OrganizationEntity {

  @Id
  private String id;
  private String name;
  private String address;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinProperty(name = "department")
  private List<DepartmentEntity> departments;
}
