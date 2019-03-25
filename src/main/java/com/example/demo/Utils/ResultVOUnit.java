package com.example.demo.Utils;

import com.example.demo.VO_viewObject.ResultVO;

public class ResultVOUnit {

    public static ResultVO success (Object object){

        ResultVO resultVO = new ResultVO();

        resultVO.setCode(0);

        resultVO.setMassge("成功！！");

        resultVO.setData(object);

        return  resultVO;

    }

    public  static  ResultVO success(){

        return success(null);
    }

    public static ResultVO error(Integer code,String msg){

        ResultVO resultVO = new ResultVO();

        resultVO.setCode(code);

        resultVO.setMassge(msg);

        return resultVO;

    }
}
