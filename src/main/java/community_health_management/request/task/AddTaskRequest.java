package community_health_management.request.task;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "添加任务")
public class AddTaskRequest {
    /**
     * 委托人id
     */
    @Schema(description = "委托人id")
    private Integer assignorId;
    /**
     * 执行人id
     */
    @Schema(description = "执行人id")
    private Integer enforcerId;

    /**
     * 卫生业务id
     */
    @Schema(description = "卫生业务id")
    private Integer helwid;

}
