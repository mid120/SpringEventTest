package com.trs.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Administrator
 *
 */
public class StudentAddBean implements ApplicationContextAware {
    /**
     * Spring  容器
     */
    private ApplicationContext m_applicationContext = null;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.context.ApplicationContextAware#setApplicationContext
     * (org.springframework.context.ApplicationContext)
     */
    public void setApplicationContext(ApplicationContext _applicationContext)
            throws BeansException {
        this.m_applicationContext = _applicationContext;

    }

    /**
     * 添加学生
     * 
     * @param _sStudentName
     */ 
    public void addStudent(String _sStudentName) {
        // 1.创建事件
        StudentAddEvent aStudentEvent = new StudentAddEvent(
                m_applicationContext, _sStudentName);
        // 2.发布事件
        m_applicationContext.publishEvent(aStudentEvent);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] xmlConfig = new String[] { "applicationContext.xml" };
        // 通过xml获取Spring 容器
        ApplicationContext context = new ClassPathXmlApplicationContext(
                xmlConfig);
        StudentAddBean studentBean = (StudentAddBean) context
                .getBean("StudentAddBean");
        studentBean.addStudent("学生甲");
        studentBean.addStudent("学生乙");

    }

}
