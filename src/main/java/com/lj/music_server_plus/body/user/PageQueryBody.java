package com.lj.music_server_plus.body.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "分页查询参数")
public class PageQueryBody<T> {
    @Schema(name = "pageCurrent", description = "当前页", requiredMode = Schema.RequiredMode.REQUIRED)
    @Min(value=1,message = "当前页不能为空")
    private Integer pageCurrent;
    @Schema(name = "pageSize", description = "每页条数", requiredMode = Schema.RequiredMode.REQUIRED)
    @Min(value = 1,message = "每页条数不能为空")
    private Integer pageSize;
    @NotNull(message = "查询条件不能为空")
    @Schema(name = "condition", description = "查询条件,不为空，但里边的参数可以", requiredMode = Schema.RequiredMode.REQUIRED)
    T condition;
}
