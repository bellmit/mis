package com.syzc.util;

import com.alibaba.fastjson.JSON;

public class PageUtil {
    public static Page make(Integer pageNo, Integer pageSize, Long totalRow) {
        if (totalRow == null) {
            return null;
        }
        if (pageSize == null || pageSize <= 0L || pageSize > 1000L) {
            pageSize = 10;
        }
        if (pageNo == null || pageNo <= 0) {
            pageNo = 1;
        }
        Long offset;
        try {
            offset = (pageNo - 1L) * pageSize;
            if (offset > totalRow - 1L) {
                pageNo = (int) ((totalRow - 1) / pageSize + 1);
                offset = (totalRow - 1L) / pageSize * pageSize;
            }
        } catch (ArithmeticException e) {
            return make(1, 10, totalRow);
        }
        Page p = new Page(totalRow);
        p.setRowOffset(offset);
        p.setPageSize(pageSize);
        arrange(p);
        return p;
    }

    /**
     * offset & rows/Page & total rows ==>> Page no & etc.
     *
     * @param page
     */
    public static void arrange(Page page) {
        int pno = (int) ((page.getRowOffset()) / page.getPageSize() + 1); // rowOffset 从0开始数…
        int maxpno = (int) ((page.getTotalRows() - 1) / page.getPageSize() + 1);
        page.setPageNo(pno);
        page.setMaxPageNo(maxpno);
    }

    public static void main(String[] args) {
        Page page = new Page(50L);
        page.setPageSize(5);
        page.setRowOffset(10L);
        arrange(page);
        System.out.println(JSON.toJSONString(page));

        System.out.println(JSON.toJSONString(make(111, 5, 50L)));
        System.out.println(JSON.toJSONString(make(111, 5, 50L)));
        System.out.println(JSON.toJSONString(make(53, 10, 500000L)));
    }
}