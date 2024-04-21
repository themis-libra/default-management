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
    public class Rra implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("Rno")
    private String Rno;

    @TableField("Rano")
    private String Rano;


}
