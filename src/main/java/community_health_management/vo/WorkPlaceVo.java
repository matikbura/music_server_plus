package community_health_management.vo;

import community_health_management.entity.WorkPlace;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "WorkPlaceVo", description = "工作场所")
public class WorkPlaceVo extends WorkPlace {

}
