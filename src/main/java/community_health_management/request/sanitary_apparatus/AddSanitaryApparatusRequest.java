package community_health_management.request.sanitary_apparatus;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Schema(description = "添加卫生器械入库")
public class AddSanitaryApparatusRequest {
    /**
     * 器械名称
     */
    @NotEmpty(message = "器械名称不能为空")
    @Schema(description = "器械名称")
    private String name;

}
