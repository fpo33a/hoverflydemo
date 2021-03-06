/*
 * Swagger demo API
 * This is demo API.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: frank_polet@hotmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Addition
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-09-11T17:22:43.696Z")



public class Addition {
  @SerializedName("field1")
  private Integer field1 = null;

  @SerializedName("field2")
  private Integer field2 = null;

  public Addition field1(Integer field1) {
    this.field1 = field1;
    return this;
  }

   /**
   * Get field1
   * @return field1
  **/
  @ApiModelProperty(value = "")
  public Integer getField1() {
    return field1;
  }

  public void setField1(Integer field1) {
    this.field1 = field1;
  }

  public Addition field2(Integer field2) {
    this.field2 = field2;
    return this;
  }

   /**
   * Get field2
   * @return field2
  **/
  @ApiModelProperty(value = "")
  public Integer getField2() {
    return field2;
  }

  public void setField2(Integer field2) {
    this.field2 = field2;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Addition addition = (Addition) o;
    return Objects.equals(this.field1, addition.field1) &&
        Objects.equals(this.field2, addition.field2);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

