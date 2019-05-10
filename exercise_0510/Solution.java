package exercise.exercise_0510;

/*
29. 两数相除
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
返回被除数 dividend 除以除数 divisor 得到的商。
示例 1:
输入: dividend = 10, divisor = 3
输出: 3
示例 2:
输入: dividend = 7, divisor = -3
输出: -2
说明:
被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
class Solution {
    public int divide(int dividend, int divisor) {
        boolean t1 = dividend <0 ? false :true;
        boolean t2 = divisor <0 ? false :true;
        long d1 = dividend >= 0 ? (long)dividend : (-(long)dividend);
        long d2 = divisor >= 0 ? (long)divisor : (-(long)divisor);
        long count = 0;
        long temp = d2;
        long d = 1;
        while(d1 >= d2 && temp >= d2){
            if(d1 >= temp){
                d1 -= temp;
                count += d;
                //System.out.println(count);
                if(d1 > (temp<<1)){
                    temp = temp << 1;//翻两倍
                    d = d << 1;
                }
            }else{
                temp = temp >> 1;
                d = d >> 1;
                if(d1 >= temp){
                    d1 -= temp;
                    count += d;
                }else{
                    temp = temp >> 1;
                    d = d >> 1;
                }
            }
        }
        return t1^t2 ? (int)(-count) :
                (count > (long)Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)count);
    }
}