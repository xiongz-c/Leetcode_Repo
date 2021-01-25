//题意：快速幂
//题解：背好快速幂模板，负数的话base取倒数
package main

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 * 
 * @param base double浮点型 
 * @param exponent int整型 
 * @return double浮点型
*/
func Power( base float64 ,  exponent int ) float64 {
    // write code here
    return binPower(base, exponent)
}

func binPower(base float64, exponent int) float64{
    if(exponent < 0){//指数为负数，取base的倒数的正数幂
            base = 1/base;
            exponent *= -1;
    }
    var res float64 = 1 
    for exponent > 0{
        if exponent & 1 == 1{
            res = res * base
        }
        base *= base
        exponent >>= 1
    }
    return res
}