//题意：实现对一个二叉树的序列化和反序列化
//题解：可以用层序遍历和先序遍历，具体操作有点复杂。这里还没写，贴上牛客上用前序遍历完成的序列化。
package main
import . "nc_tools"
import "fmt"
/*
 * type TreeNode struct {
 *   Val int
 *   Left *TreeNode
 *   Right *TreeNode
 * }
 */

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param root TreeNode类 
 * @return TreeNode类
*/
var str string
func Serialize( root *TreeNode ) *TreeNode {
    // write code here
	str = serialize(root)
     
    return deSerialize()
}

func serialize(root *TreeNode) string {
    if root == nil {
        return "#"
    }
     
    return fmt.Sprintf("%d %s %s", root.Val, serialize(root.Left), serialize(root.Right))
}
 
func deSerialize() *TreeNode {
    if str == "" {
        return nil
    }
     
    index := strings.Index(str, " ")
    if index == -1 {
        index = len(str)
    }
    target := str[:index]
     
    if index == len(str) {
        str = ""
    } else {
        str = str[index+1:]
    }
     
    if target == "#" {
        return nil
    }
     
    t := new(TreeNode)
    t.Val, _ = strconv.Atoi(target)
     
    t.Left = deSerialize()
    t.Right = deSerialize()
     
    return t
}