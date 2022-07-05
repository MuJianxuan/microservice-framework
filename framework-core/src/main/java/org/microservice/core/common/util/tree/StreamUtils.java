package org.microservice.core.common.util;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 流组件
 *   1、list to tree
 *   2、去重
 * @author Rao
 * @Date 2021/11/10
 **/
public class StreamUtils {

    /**
     * 集合转菜单树
     * @param allTreeNodeList
     * @param <T>
     * @return
     */
    public static  <T> List<TreeNode<T>> listToMenuTree(List<TreeNode<T>> allTreeNodeList){

        Iterator<TreeNode<T>> iterator = allTreeNodeList.iterator();

        return allTreeNodeList.stream()
                // 从最外层开始
                .filter(TreeNode::isTopId)
                // 处理每一个一级
                .map(topNode -> topNode.setChildList( StreamUtils.getChildren(topNode, allTreeNodeList) ) )
                // 收集所有的一级
                .collect(Collectors.toList());
    }

    /**
     * 获取 孩子们
     * @param root
     * @param allTreeNodeList
     * @param <T>
     * @return
     */
    private static <T> List<TreeNode<T>> getChildren(TreeNode<T> root, List<TreeNode<T>> allTreeNodeList) {

        return allTreeNodeList.stream()
                // 找每一个 儿子  （这里的判断可能有问题）
                .filter(node -> String.valueOf( root.getId()).equals(String.valueOf( node.getParentId()) ))
                // 让儿子 变成一个 完美的儿子
                .map(node -> node.setChildList(StreamUtils.getChildren(node, allTreeNodeList)))
                // 收集儿子们
                .collect(Collectors.toList());
    }
}
