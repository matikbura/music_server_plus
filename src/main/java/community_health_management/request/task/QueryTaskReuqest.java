package community_health_management.request.task;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "任务查询")
public class QueryTaskReuqest {

    /**
     * 执行人id
     */
    @Schema(description = "执行人id")
    private Integer enforcerId;

    /**
     * 委托人id
     */
    @Schema(description = "委托人id")
    private Integer assignorId;

    /**
     * 关键此
     */
    @Schema(description = "关键词")
    private String keyword;

    /**
     * 卫生业务id
     */
    @Schema(description = "卫生业务id")
    private Integer helwid;

    /**
     * 任务状态
     */
    @Schema(description = "任务状态")
    private Integer status;

}
