package project.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2023-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DefaultApplication implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableField("id")
  @JsonProperty(value = "id")
  private int id;

  @TableField("Dcname")
  @JsonProperty(value="Dcname")
  private String Dcname;

  @TableField("Dlevel")
  @JsonProperty(value="Dlevel")
  private String Dlevel;

  @TableField("Danote")
  @JsonProperty(value="Danote")
  private String Danote;

  @TableField("Dano")
  @JsonProperty(value="Dano")
  private String Dano;

  @TableField("Datime")
  @JsonProperty(value="Datime")
  private String Datime;

  @TableField("Dname")
  @JsonProperty(value="Dname")
  private String Dname;

  @TableField("Rgoavity")
  @JsonProperty(value="Rgoavity")
  private String Rgoavity;

  @TableField("Dcstatus")
  @JsonProperty(value="Dcstatus")
  private String Dcstatus;


  @TableField("Dauditor")
  @JsonProperty(value="Dauditor")
  private String Dauditor;


  @TableField("Dctime")
  @JsonProperty(value="Dctime")
  private String Dctime;
}
