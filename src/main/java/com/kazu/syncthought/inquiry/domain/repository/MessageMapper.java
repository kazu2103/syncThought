package com.kazu.syncthought.inquiry.domain.repository;
 
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;

import com.kazu.syncthought.inquiry.domain.model.Message;
 
@Mapper
public interface MessageMapper {
    
    @Select("SELECT ID, USERNAME, MAIL, MESSAGE FROM T_MESSAGE ORDER BY ID")
    Collection<Message> findAll();
    
    @Select("SELECT ID, USERNAME, MAIL, MESSAGE FROM T_MESSAGE WHERE id = #{id}")
    Message findById(Long id);
    
    @Insert("INSERT INTO T_MESSAGE ( ID, USERNAME, MAIL, MESSAGE ) VALUES (#{id}, #{username}, #{mail}, #{message})")
    void create(Message message);
}