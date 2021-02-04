package com.feather.prd.domain;

import java.util.Date;

import com.feather.common.core.domain.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 消息发送日志用户对象 prd_msg_user
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrdMsgUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    // status: 0成功 1失败 9等待
    public static final Byte WAITING = 9;

    private Long msgId;
    private Long userId;

    private String loginName;
    private String userName;

    private String phonenumber;
    private String openid;

    /** 发送时间 */
    private Date sendTime;
    /** 发送次数 */
    private int sendCount;

    /** 发送错误 */
    private String sendError;
}
