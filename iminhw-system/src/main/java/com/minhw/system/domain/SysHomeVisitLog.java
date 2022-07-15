package com.minhw.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 前台用户访问记录对象 sys_homepage_visit_log
 *
 * @author iminhw
 * @date 2022-07-15
 */
public class SysHomeVisitLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 日志主键
     */
    @Excel(name = "操作序号", cellType = Excel.ColumnType.NUMERIC)
    private Long visitId;

    /**
     * 模块标题
     */
    @Excel(name = "访问模块")
    private String title;

    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    @Excel(name = "业务类型", readConverterExp = "0=其它,1=新增,2=修改,3=删除,4=授权,5=导出,6=导入,7=强退,8=生成代码,9=清空数据,10=前台访问")
    private Long businessType;

    /**
     * 业务类型数组
     */
    private Integer[] businessTypes;

    /**
     * 方法名称
     */
    @Excel(name = "请求方法")
    private String method;

    /**
     * 请求方式
     */
    @Excel(name = "请求方式")
    private String requestMethod;

    /**
     * 请求URL
     */
    @Excel(name = "请求URL")
    private String visitUrl;

    /**
     * 主机地址
     */
    @Excel(name = "访问IP")
    private String visitIp;

    /**
     * 操作地点
     */
    @Excel(name = "访问地点")
    private String visitLocation;

    /**
     * 请求参数
     */
    @Excel(name = "请求参数")
    private String visitParam;

    /**
     * 返回参数
     */
    @Excel(name = "返回参数")
    private String jsonResult;

    /**
     * 操作状态（0正常 1异常）
     */
    @Excel(name = "操作状态", readConverterExp = "0=正常,1=异常")
    private Long status;

    /**
     * 错误消息
     */
    @Excel(name = "错误消息")
    private String errorMsg;

    /**
     * 访问时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "访问时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date visitTime;

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Long businessType) {
        this.businessType = businessType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getVisitUrl() {
        return visitUrl;
    }

    public void setVisitUrl(String visitUrl) {
        this.visitUrl = visitUrl;
    }

    public String getVisitIp() {
        return visitIp;
    }

    public void setVisitIp(String visitIp) {
        this.visitIp = visitIp;
    }

    public String getVisitLocation() {
        return visitLocation;
    }

    public void setVisitLocation(String visitLocation) {
        this.visitLocation = visitLocation;
    }

    public String getVisitParam() {
        return visitParam;
    }

    public void setVisitParam(String visitParam) {
        this.visitParam = visitParam;
    }

    public String getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer[] getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(Integer[] businessTypes) {
        this.businessTypes = businessTypes;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }
}
