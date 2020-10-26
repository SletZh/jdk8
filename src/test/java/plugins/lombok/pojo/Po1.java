package plugins.lombok.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author SletZh
 * @Date 2020-09-16-9:46
 */
@Builder
@ToString
@Data
public class Po1 {
    private String var1;
    private String var2;
    private String var3;
}
