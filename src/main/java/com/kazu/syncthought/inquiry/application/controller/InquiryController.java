package com.kazu.syncthought.inquiry.application.controller;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.kazu.syncthought.inquiry.domain.model.Message;
import com.kazu.syncthought.inquiry.domain.model.MessageForm;
import com.kazu.syncthought.inquiry.domain.repository.MessageMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(types = {MessageForm.class})
public class InquiryController {
    
    @Autowired
    MessageMapper messageMapper;

    @ModelAttribute
    MessageForm setupForm() {
        return new MessageForm();
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView get(ModelAndView mav){
        mav.setViewName("index");
        mav.addObject("errMsg", "");
        mav.addObject("messageForm", new MessageForm());
        mav.addObject("messages", messageMapper.findAll());
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView create(@Validated MessageForm form, BindingResult result, ModelAndView mav, @RequestParam("username") String username, @RequestParam("mail") String mail,  @RequestParam("message") String message){
        mav.setViewName("index");
        mav.addObject("errMsg", "");
        mav.addObject("messageForm", new MessageForm());
        mav.addObject("messages", messageMapper.findAll());

        if(result.hasErrors()){
            mav.addObject("errMsg", "値が不正です。 ");
        }

        Message msg = new Message();
        msg.setUsername(username);
        msg.setMail(mail);
        msg.setMessage(message);
        messageMapper.create(msg);

        return mav;
    }

}
