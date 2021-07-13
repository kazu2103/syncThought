package com.kazu.syncthought.inquiry.domain.model;

import lombok.Data;

@Data
public class Message {

    /** ID */
    private long id;
 
    /** 名前 */
    private String username;
  
    /** メールアドレス */
    private String mail;
 
    /** メッセージ */
    private String message;
}
