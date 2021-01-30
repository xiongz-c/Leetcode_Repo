//题意：判断某个二叉树是不是另一个的子结构
//题解：前序遍历的包含关系，自己写的不太优雅的方式是遍历完比较，标准写法很妙【代码量少】

package main
import . "nc_tools"

/**标准写法
func hasSubtree( pRoot1 *TreeNode ,  pRoot2 *TreeNode ) bool {
        return (pRoot1 != nil && pRoo2 != nil) && (recur(pRoot1, pRoot2) || isSubStructure(pRoot1.left, pRoot2) || isSubStructure(pRoot1.right, pRoot2));
    }
    func recur( pRoot1 *TreeNode ,  pRoot2 *TreeNode ) bool {
        if(pRoot2 == null) return true;
        if(pRoot1 == null || pRoot1.val != pRoot2.val) return false;
        return recur(pRoot1.left, pRoot2.left) && recur(pRoot1.right, pRoot2.right);
    }

*/

func HasSubtree( pRoot1 *TreeNode ,  pRoot2 *TreeNode ) bool {
    // write code here
    if pRoot1 == nil || pRoot2 == nil {
        return false
    }
    s1 := make([]int, 0)
    s2 := make([]int, 0)
    s1 = reorder(pRoot1, s1)
    s2 = reorder(pRoot2, s2)
    fmt.Println(s1)
    fmt.Println(s2)
    return inSlice(s1,s2)
}

func reorder( root *TreeNode, slice []int) []int{
    slice = append(slice,root.Val)
    if root.Left != nil {
        slice = reorder(root.Left,slice)
    }
    if root.Right != nil {
        slice = reorder(root.Right,slice)
    }
    return slice
}

func inSlice(s1 []int, s2 []int) bool{
    for i:=0;i<len(s1) - len(s2)+1;i++{
        k := i
        for j:=0;j < len(s2);j++{
            if s2[j] != s1[k] {
                break
            }
            k++
            if j == len(s2) - 1{
                return true
            }
        }
    }
    return false
}
