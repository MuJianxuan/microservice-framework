package org.microservice.core.common.exception.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Rao
 * @Date 2021/11/10
 **/
public class ExceptionNotifyEvent<T> extends ApplicationEvent {
    private static final long serialVersionUID = 6313929773721278336L;

    public ExceptionNotifyEvent(T source) {
        super(source);
    }

    /**
     * 获取传递对象
     * @return
     */
    public T getTransferSource(){
        return (T) this.getSource();
    }

}
