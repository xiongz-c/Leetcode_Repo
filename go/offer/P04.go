//题意：已知前序和中序重建树
//题解：递归，找到中序的根节点位置->中序的性质是根节点两边分别是左右子树节点

package main

type TreeNode struct {
   Val int
   Left *TreeNode
   Right *TreeNode
}


/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param pre int整型一维数组 
 * @param vin int整型一维数组 
 * @return TreeNode类
*/
func reConstructBinaryTree( pre []int ,  vin []int ) *TreeNode {
    // write code here
    return buildTree(0, 0, len(vin) - 1, pre, vin)
}

func buildTree(preBegin int, inStart int, inEnd int, pre []int, vin []int) *TreeNode {
    if preBegin >= len(pre) || inStart > inEnd{
        return nil
    }
    root := new(TreeNode)
    rootIndex := 0//the position of root in inorder
    for i:=inStart;i<=inEnd;i++{
        if vin[i] == pre[preBegin]{
            rootIndex = i
            break
        }
    }
    root.Val = pre[preBegin]
    root.Left = buildTree(preBegin+1,inStart,rootIndex-1,pre,vin)
    root.Right = buildTree(preBegin+1+rootIndex-inStart,rootIndex+1,inEnd,pre,vin)
    return root
}