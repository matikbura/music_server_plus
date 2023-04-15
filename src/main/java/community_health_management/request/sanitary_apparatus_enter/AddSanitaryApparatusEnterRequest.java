package community_health_management.request.sanitary_apparatus_enter;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "AddRequest", description = "录入器械请求")
@Data
public class AddSanitaryApparatusEnterRequest {
    /**
     * 卫生器械id
     */
    @Schema(description = "卫生器械id")
    private Integer said;

    /**
     * 数量
     */
    @Schema(description = "数量")
    private Integer num;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

}
