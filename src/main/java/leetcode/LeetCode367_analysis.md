【数据结构和算法】有效的完全平方数（6种解决方式）
数据结构和算法

解法一
先开平方，然后在相乘

    public boolean isPerfectSquare(int num) {
        //先开平方
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

解法二
这题说的是数字num是否是完全平方数，我们知道1+3+5+……+n的和是完全平方数，我们只需要用num减去他们即可。

    public boolean isPerfectSquare(int num) {
        int a = 1;
        while (num > 0) {
            num -= a;
            a += 2;
        }
        return num == 0;
    }

解法三
我们知道数字num的平方根肯定是在1-num之间，我们可以通过二分法来查找他的平方根，然后平方根相乘判断是否等于num


    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sqrt = 1L * mid * mid;
            if (sqrt == num) {
                return true;
            } else if (sqrt < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

解法四
如果num是完全平方数并且能被a整除，那么num肯定能被a整除两次，如果只能被a整除一次，说明num不是完全平方数。

    public boolean isPerfectSquare(int num) {
        if (num == Integer.MAX_VALUE)
            return false;
        int a = 2;
        while (num > 1 && a * a <= num) {
            if (num % a == 0) {
                num /= a;
                //如果num是平方数并且能被a整除，那么肯定
                //能被他整除两次，如果只能被a整除一次，说明
                //num不是平方数
                if (num % a == 0) {
                    num /= a;
                } else {
                    //只能被a整除一次，说明不是平方数，
                    //直接返回false
                    return false;
                }
            } else {
                a++;
            }
        }
        return num == 1;
    }

解法五
位运算解决，我们不要把num看做是一个十进制的数字，而是把它看做一个二进制的数字。那么很明显num平方根的高16位全是0，如果有一个不是0，那么他的平方肯定是超过int的数字范围，所以我们只需要考虑低16位上的数字是0还是1即可。我们从右边数第16位开始考虑，先把他变为1

如果相乘等于num我们直接返回true，
如果相乘大于num，说明太大了我们就把当前位置变为0，
否则他们相乘是小于num，说明太小了，我们就不要改变，实际上当前位置还是1

    public boolean isPerfectSquare(int num) {
        long temp = 0, bit = 1 << 15;
        while (bit > 0) {
            temp |= bit;
            long a = temp * temp;
            if (a == num) {
                return true;
            } else if (a > num) {
                //太大了，把当前位置变为0
                temp ^= bit;
            }
            bit >>= 1;
        }
        return temp * temp == num;
    }

解法六
这个就是使用牛顿迭代法

    public boolean isPerfectSquare(int num) {
        long a = num;
        while (a * a > num) {
            a = (a + num / a) >> 1;
        }
        return a * a == num;
    }