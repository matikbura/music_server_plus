package community_health_management.request.task;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "处理超时任务")
public class UpdateForProcessRequest {
    /**
     * 任务id
     */
    @Schema(description = "任务id")
    private Integer tid;
    /**
     * 处理超时任务备注
     */
    @Schema(description = "处理超时任务备注")
    private String processTimeoutRemark;
}
