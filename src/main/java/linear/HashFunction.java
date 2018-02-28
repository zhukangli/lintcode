package linear;

/**
 * 在数据结构中，哈希函数是用来将一个字符串（或任何其他类型）转化为
 * 小于哈希表大小且大于等于零的整数。
 * 一个好的哈希函数可以尽可能少地产生冲突。
 * 一种广泛使用的哈希函数算法是使用数值33，
 * 假设任何字符串都是基于33的一个大整数，比如：

 hashcode("abcd") = (ascii(a) * 33^3 + ascii(b) * 33^2 + ascii(c) *33 + ascii(d))
 % HASH_SIZE

 = (97* 33^3 + 98 * 33^2 + 99 * 33 +100) % HASH_SIZE

 = 3595978 % HASH_SIZE

 其中HASH_SIZE表示哈希表的大小(可以假设一个哈希表就是一个索引0 ~ HASH_SIZE-1的数组)。

 给出一个字符串作为key和一个哈希表的大小，返回这个字符串的哈希值。
 * Created by Conley on 2018/2/25.
 *
 * 解题思路：
 *      注意，这个取模，就保证了所得到的hash值小于哈希表的大小
 *
 */
public class HashFunction {
    /*
    * @param key: A string you should hash
    * @param HASH_SIZE: An integer
    * @return: An integer
    */
    public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        int len = key.length;
        long hashcode = 0;
        long base = 1;
        for(int i=len-1;i>=0;i--){
            hashcode = hashcode  + Integer.valueOf(key[i])*base % HASH_SIZE;
            hashcode = hashcode%HASH_SIZE;
            base = base *33% HASH_SIZE;
        }
        return (int)hashcode;

    }

    public static void main(String[] args) {
        char[] ch = new char[]{'a','b','c','d'};
        System.out.println(new HashFunction().hashCode(ch,100));
    }

}
