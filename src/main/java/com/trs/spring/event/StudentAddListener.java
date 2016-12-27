package com.trs.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 自定义监听器
 * @author Administrator
 *
 */
@SuppressWarnings("rawtypes")
public class StudentAddListener implements ApplicationListener {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.context.ApplicationListener#onApplicationEvent(org
     * .springframework.context.ApplicationEvent)
     */
    public void onApplicationEvent(ApplicationEvent _event) {
        // 1.判断是不是自己自定义的监听类型
        if (!(_event instanceof StudentAddEvent)) {
            return;
        }

        // 2.获取需要监听的事件类型
        StudentAddEvent studentAddEvent = (StudentAddEvent) _event;
        System.out.println("StudentAddListener:::" + studentAddEvent.getStudentName());
    }

}
