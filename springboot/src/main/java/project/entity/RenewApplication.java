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
public class RenewApplication implements Serializable {

  private static final long serialVersionUIR = 1L;

  @TableField("id")
  @JsonProperty(value = "id")
  private int id;

  @TableField("Rcname")
  @JsonProperty(value = "Rcname")
  private String Rcname;


  @TableField("Rlevel")
  @JsonProperty(value = "Rlevel")
  private String Rlevel;

  @TableField("Ranote")
  @JsonProperty(value = "Ranote")
  private String Ranote;

  @TableField("Rano")
  @JsonProperty(value = "Rano")
  private String Rano;

  @TableField("Ratime")
  @JsonProperty(value = "Ratime")
  private String Ratime;

  @TableField("Rname")
  @JsonProperty(value = "Rname")
  private String Rname;

  @TableField("RRgoavity")
  @JsonProperty(value = "RRgoavity")
  private String RRgoavity;

  @TableField("Rcstatus")
  @JsonProperty(value = "Rcstatus")
  private String Rcstatus;


  @TableField("Rauditor")
  @JsonProperty(value = "Rauditor")
  private String Rauditor;


  @TableField("Rctime")
  @JsonProperty(value = "Rctime")
  private String Rctime;

  @TableField("Rreson")
  @JsonProperty(value = "Rreson")
  private String Rreson;

}
