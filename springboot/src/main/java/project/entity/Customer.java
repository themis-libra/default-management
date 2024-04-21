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
    public class Customer implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("Cname")
    private String Cname;

    @TableField("Profession")
    private String Profession;

    @TableField("Area")
    private String Area;

    @TableField("Ctype")
    private String Ctype;

    private String password;

    private String Ccharacter;


}
