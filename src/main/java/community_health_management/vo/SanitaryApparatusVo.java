package community_health_management.vo;

import community_health_management.entity.SanitaryApparatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Schema(name = "SanitaryApparatusVo", description = "卫生器械")
@Data
public class SanitaryApparatusVo extends SanitaryApparatus {
}
