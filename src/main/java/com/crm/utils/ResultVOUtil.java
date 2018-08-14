package com.crm.utils;

import com.crm.VO.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setSuccess(true);
        resultVO.setMsg("成功");
        return  resultVO;
    }
    public  static  ResultVO success() {
        return success(null);
    }
    public static ResultVO error() {
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(false);
        resultVO.setMsg("错误");
        return resultVO;
    }

}