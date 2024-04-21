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
    public class DefaultCheck implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("Dcno")
    private String Dcno;

    @TableField("Dcstatus")
    private String Dcstatus;

    @TableField("Dchecker")
    private String Dchecker;

    @TableField("Dctime")
    private String Dctime;


}
