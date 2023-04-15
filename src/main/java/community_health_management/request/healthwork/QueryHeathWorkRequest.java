package community_health_management.request.healthwork;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class QueryHeathWorkRequest {

    /**
     * 工作地点id
     */
    @Schema(description = "工作地点id")
    private Integer wpid;

    /**
     * 卫生业务名称
     */
    @Schema(description = "卫生业务名称")
    private String name;

    /**
     * 工作时间间隔（日）
     */
    @Schema(description = "工作时间间隔（日）")
    private Integer workDurationTime;
    /**
     * 预计工作时长（小时）
     */
    @Schema(description = "预计工作时长（小时）")
    private Integer expTime;
    /**
     * 上一次
     */
    @Schema(description = "是否查询还没有发布完成的工作")
    private Boolean isWork;
}
