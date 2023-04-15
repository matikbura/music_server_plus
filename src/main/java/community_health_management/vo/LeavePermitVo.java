package community_health_management.vo;

import community_health_management.entity.LeavePermit;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Schema(name = "LeavePermitVo", description = "请假条")
@Data
public class LeavePermitVo extends LeavePermit {
    //审核人信息
    @Schema(description = "审核人姓名")
    private UserVo auditorUser;
    //申请人信息
    @Schema(description = "申请人姓名")
    private UserVo applicantUser;
}
