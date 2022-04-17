package com.auth.sunia.star247.auth.server.bean.auth;

/**
 * @version 1.0
 * @author: star247@sunia.com
 * @date: 2022/3/31 19:22
 * @describe: 版本授权顶层接口<br>
 */
public interface VerAuthInterface {
    void apple();


    /**
     * 是否可用，根据实际情况判断包名等
     * @return
     */
//    AppIdInfoDTO check(LicenseRequest licenseRequest,AppIdInfoDTO appIdInfoDTO ) throws LicenseException;
    /**
     * 数量是否有剩余,有数量则返回其授权序号
     */
//    Long haveChance(String appid);

    /**
     * 是否过期或超出使用数量显限制,预先判断，不作为最后是否过期/超出的依据
     * @return
     */
//    Boolean isExpirePre(String appid) throws LicenseException;
    /**
     * 授权
     * @param resp
     * @return
     * @throws Exception
     */
//    CommonResponse<String> licenseCommit(CommonResponse<String> resp, LicenseRequest licenseRequest) throws Exception;

//    Boolean authHandle(AppIdInfoDTO appIdInfoDTO, LicenseRequest licenseRequest, String index,CommonResponse<String> resp) throws Exception;


    /**
     * 构造返回参数
     * @param appIdInfoDTO appid信息
     * @param recordDTO 激活记录信息
     * @param respCode 状态编码
     * @param index 公私钥对索引
     * @param rules 规则
     * @return
     */
//    String ConstructRespData(AppIdInfoDTO appIdInfoDTO, LicenseRecordDTO recordDTO, String respCode, String index, String rules) throws LicenseException;
}
