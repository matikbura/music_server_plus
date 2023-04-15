package community_health_management.request.healthwork;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
@Data
public class UpdateHeathWorkRequest {
    /**
     * 卫生工作id
     */
    @Schema(description = "卫生工作id")
    private Integer hwid;

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
     * 上一次
     */
    @Schema(description = "上一次")
    private Date lastTime;
    /**
     * 预计工作时长（小时）
     */
    @Schema(description = "预计工作时长（小时）")
    private Integer expTime;
}
