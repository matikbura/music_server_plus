package community_health_management.vo;

import community_health_management.entity.SanitaryApparatus;
import community_health_management.entity.SanitaryApparatusEnter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SanitaryApparatusEnterVo", description = "卫生器械入库")
public class SanitaryApparatusEnterVo extends SanitaryApparatusEnter {
    SanitaryApparatus sanitaryApparatus;
    UserVo Writer;
}
