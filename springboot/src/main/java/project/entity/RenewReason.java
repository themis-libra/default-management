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
    public class RenewReason implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("RContent")
    private String RContent;

    @TableField("Rno")
    private String Rno;


}
