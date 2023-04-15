package community_health_management.vo;

import community_health_management.entity.Task;
import community_health_management.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "TaskVo", description = "任务")
public class TaskVo extends Task{
    /**
     * 委托人
     */
    @Schema(description = "委托人")
    User assignorUser;
    /**
     * 被委托人
     */
    @Schema(description = "执行人")
    User enforcerUser;
    /**
     * 卫生业务
     */
    @Schema(description = "卫生业务")
    HealthWorkVo healthWorkVo;
}
