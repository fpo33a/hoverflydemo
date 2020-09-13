package io.swagger.server.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Upper   {
  
  private String upper = null;

  public Upper () {

  }

  public Upper (String upper) {
    this.upper = upper;
  }

    
  @JsonProperty("upper")
  public String getUpper() {
    return upper;
  }
  public void setUpper(String upper) {
    this.upper = upper;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Upper upper = (Upper) o;
    return Objects.equals(upper, upper.upper);
  }

  @Override
  public int hashCode() {
    return Objects.hash(upper);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Upper {\n");
    
    sb.append("    upper: ").append(toIndentedString(upper)).append("\n");
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
