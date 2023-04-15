package community_health_management.vo;

import community_health_management.entity.SanitaryApparatus;
import community_health_management.entity.SanitaryApparatusLoss;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SanitaryApparatusLossVo", description = "卫生器械损坏")
public class SanitaryApparatusLossVo extends SanitaryApparatusLoss {
    SanitaryApparatus sanitaryApparatus;
    UserVo writer;
}
