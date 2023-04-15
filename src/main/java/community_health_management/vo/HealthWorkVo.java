package community_health_management.vo;

import community_health_management.entity.HealthWork;
import community_health_management.entity.WorkPlace;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Schema(name = "HealthWorkVo", description = "卫生业务")
@Data
public class HealthWorkVo extends HealthWork {
    WorkPlace workPlace;
}
