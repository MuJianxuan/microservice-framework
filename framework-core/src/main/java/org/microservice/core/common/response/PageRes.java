package org.microservice.core.common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Rao
 * @Date 2021/11/04
 **/
@Data
public class PageRes implements Serializable {

    /**
     * 总数
     */
    private Long total;

    /**
     * 页
     */
    private Long current;

    /**
     * 页数
     */
    private Long size;

    private static final long serialVersionUID = 501985925788143587L;
}
