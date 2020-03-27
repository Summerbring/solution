package com.code.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author Summer 2020/03/27 14:41
 */
public class HasGroupsSizeX {

    /**
     * 给定一副牌，每张牌上都写着一个整数。
     *
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     *
     * 每组都有 X 张牌。
     * 组内所有的牌上都写着相同的整数。
     * 仅当你可选的 X >= 2 时返回 true。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。给定一副牌，每张牌上都写着一个整数。
     * 示例 1：
     *
     * 输入：[1,2,3,4,4,3,2,1]
     * 输出：true
     * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
     *
     * 思路，寻找K，首先，查找数组最小的相同元素的个数
     *
     * @param deck
     * @author Summer 2020-03-27 9:51
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {

        if(deck.length < 2){
            return false;
        }

        Map<Integer,Integer> map = new HashMap<>();

        int min = deck[0];

        for(int i = 0; i < deck.length; i++) {

            if(map.containsKey(deck[i])){

                int value = map.get(deck[i]) + 1;

                if(map.get(min) > value ){

                    min = deck[i];

                }

                map.put(deck[i],value);

            }else{

                map.put(deck[i],1);

            }

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if(gcd( entry.getValue() , map.get(min)) == 1){
                return false;
            }

        }


        return true;

    }
    //取最小公因数
    public static int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

}
