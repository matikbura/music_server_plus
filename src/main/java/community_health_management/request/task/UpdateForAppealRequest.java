package community_health_management.request.task;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "申诉任务")
public class UpdateForAppealRequest {
    /**
     * 任务id
     */
    @Schema(description = "任务id")
    private Integer tid;
    /**
     * 申诉备注
     */
    @Schema(description = "申诉备注")
    private String appealRemark;
}
