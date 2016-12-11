package com.inuker.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dingjikerbo on 2016/12/11.
 */

/**
 * TestCases
 * [], lower=1, upper=1
 * [2147483647], lower=0,upper=2147483647
 */
public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new LinkedList<String>();
        long next = lower;
        for (int n : nums) {
            if (n < next) {
                continue;
            }

            if (n == next) {
                next++;
                continue;
            }

            list.add(getRange(next, n - 1));

            // 这里要注意溢出
            next = (long) n + 1;
        }

        if (next <= upper) {
            list.add(getRange(next, upper));
        }

        return list;
    }

    private String getRange(long start, int end) {
        return start == end ? String.valueOf(start) : start + "->" + end;
    }
}
