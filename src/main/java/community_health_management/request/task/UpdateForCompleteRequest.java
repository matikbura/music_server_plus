package community_health_management.request.task;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "完成任务")
public class UpdateForCompleteRequest {
    /**
     * 任务id
     */
    @Schema(description = "任务id")
    private Integer tid;
    /**
     * 完成任务备注
     */
    @Schema(description = "完成任务备注")
    private String completeRemark;
    /**
     * 资源列表 用逗号隔开
     */
    @Schema(description = "资源列表 用逗号隔开")
    private String sourceList;
}
