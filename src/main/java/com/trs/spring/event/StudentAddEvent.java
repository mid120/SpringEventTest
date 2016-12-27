package com.trs.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * 扩展Spring监听事件
 */
public class StudentAddEvent extends ApplicationEvent {

    /**
     * 
     */
    private static final long serialVersionUID = 20L;

    /**
     * 
     */
    private String m_sStudentName;

    /**
     * @param source
     */
    public StudentAddEvent(Object source, String _sStudentName) {
        super(source);
        this.m_sStudentName = _sStudentName;
    }

    /**
     * 获得学生名称
     * 
     * @return
     */
    public String getStudentName() {
        return m_sStudentName;
    }

}
