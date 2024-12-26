package org.microservice.ddd.domain.service;


import org.microservice.ddd.domain.entity.Award;

/**
 * @author create 2022/8/30 by rao
 */
public interface Lottery {

    /**
     * 抽奖方法
     * @return
     */
    Award lottery();

}
