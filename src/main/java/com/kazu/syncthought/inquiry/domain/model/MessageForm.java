package com.kazu.syncthought.inquiry.domain.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MessageForm {
 
    /** 名前 */
    @NotEmpty
    @Size(min = 1, max = 255)
    private String username;

    /** メールアドレス */
    @NotEmpty
    @Size(min = 1, max = 255)
    private String mail;
 
    /** メッセージ */
    @NotEmpty
    @Size(min = 1, max = 255)
    private String message;
}
