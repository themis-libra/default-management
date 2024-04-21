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
    public class Dda implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("Dno")
    private String Dno;

    @TableField("Dano")
    private String Dano;


}
