package io.swagger.server.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Addition   {
  
  private Integer field1 = null;
  private Integer field2 = null;

  public Addition () {

  }

  public Addition (Integer field1, Integer field2) {
    this.field1 = field1;
    this.field2 = field2;
  }

    
  @JsonProperty("field1")
  public Integer getField1() {
    return field1;
  }
  public void setField1(Integer field1) {
    this.field1 = field1;
  }

    
  @JsonProperty("field2")
  public Integer getField2() {
    return field2;
  }
  public void setField2(Integer field2) {
    this.field2 = field2;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Addition addition = (Addition) o;
    return Objects.equals(field1, addition.field1) &&
        Objects.equals(field2, addition.field2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field1, field2);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Addition {\n");
    
    sb.append("    field1: ").append(toIndentedString(field1)).append("\n");
    sb.append("    field2: ").append(toIndentedString(field2)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
