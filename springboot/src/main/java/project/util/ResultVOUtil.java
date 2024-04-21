package project.util;


import project.vo.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO fail(){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(-1);
        return resultVO;
    }

}
