package com.zyn.zzu.tinytwitter.service;


import com.zyn.zzu.common.utils.R;

import java.util.List;

/**
 * 
 *
 * @author zyn
 * @email sunlightcs@gmail.com
 * @date 2022-11-02 13:11:10
 */
public interface VisitRecordService {

    List<Integer> getHotContents();

    R vistContent (Integer contentId);

}

