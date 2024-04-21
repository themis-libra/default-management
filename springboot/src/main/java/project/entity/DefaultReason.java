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
    public class DefaultReason implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("DContent")
    private String DContent;

    @TableField("Dno")
    private String Dno;


}
