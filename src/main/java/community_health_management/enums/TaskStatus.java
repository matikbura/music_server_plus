package community_health_management.enums;

import lombok.Getter;

@Getter
public enum TaskStatus {
    MUSIC(0, "待完成"),
    COMPLETE(1, "待检查"),
    REJECT(2, "驳回"),
    TIMEOUT(3, "超时"),
    APPEAL(4, "申诉"),
    PROCESS_TIMEOUT(5, "处理超时"),
    PASS(8, "通过"),
    ;
    final int typeNum;
    final String typeName;
    TaskStatus(int typeNum, String typeName) {
        this.typeNum = typeNum;
        this.typeName = typeName;
    }
}
