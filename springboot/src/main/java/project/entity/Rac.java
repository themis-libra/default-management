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
    public class Rac implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("Rano")
    private String Rano;

    @TableField("Rcno")
    private String Rcno;


}
