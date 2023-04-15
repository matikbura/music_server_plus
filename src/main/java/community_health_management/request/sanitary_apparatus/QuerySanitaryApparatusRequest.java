package community_health_management.request.sanitary_apparatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "查询卫生器械入库")
public class QuerySanitaryApparatusRequest {
    /**
     * 器械名称
     */
    @Schema(description = "器械名称")
    private String name;
}
