package community_health_management.request.task;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "驳回任务")
public class UpdateForRejectRequest {
    /**
     * 任务id
     */
    @Schema(description = "任务id")
    private Integer tid;
    /**
     * 驳回任务备注
     */
    @Schema(description = "驳回任务备注")
    private String rejectRemark;
}
