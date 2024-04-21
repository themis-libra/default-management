package project.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
    public class RenewCheck implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("Rcno")
    private String Rcno;

    @TableField("Rcstatus")
    private String Rcstatus;

    @TableField("Rchecker")
    private String Rchecker;

    @TableField("Rctime")
    private String Rctime;


}
