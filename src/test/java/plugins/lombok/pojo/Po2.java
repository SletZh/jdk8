package plugins.lombok.pojo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author SletZh
 * @Date 2020-09-16-9:46
 */
@Accessors(chain = true)
@ToString
@Data
public class Po2 {
    private String var1;
    private String var2;
    private String var3;
}
