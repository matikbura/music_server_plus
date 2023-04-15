package community_health_management.request.sanitary_apparatus;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "修改卫生器械入库")
public class UpdateSanitaryApparatusRequest {
    /**
     * 卫生器械id
     */
    @Schema(description = "卫生器械id")
    @NotNull(message = "卫生器械id不能为空")
    private Integer said;

    /**
     * 器械名称
     */
    @Schema(description = "器械名称")
    private String name;
}
