package org.microservice.core.common.util.tree;

import java.util.List;

/**
 * @author Rao
 * @Date 2021/11/10
 **/
public interface TreeNode<T> {

    /**
     * ID
     * @return
     */
    Object getId();

    /**
     * 父级ID
     * @return
     */
    Object getParentId();

    /**
     * 获取数据节点
     * @return
     */
    default T getData(){
        return (T) this;
    };

    /**
     * 设置孩子们
     */
    TreeNode<T> setChildList(List<TreeNode<T>> childList);

    /**
     * 一级
     * @return
     */
    boolean isTopId();

}
