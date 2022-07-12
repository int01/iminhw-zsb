package com.minhw.stu.domain;

import com.minhw.common.annotation.Excel;
import com.minhw.common.core.domain.BaseEntity;

/**
 * 通知书邮寄记录对象 stu_out_notification
 * 这里的Excel操作主要提供给针式打印的导入  导出也使用此模版
 *
 * @author iminhw
 * @date 2022-07-12
 */
public class StuOutNotificationStylusPrinting extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 考生号
     */
    @Excel(prompt = "考生号，不可重复", name = "内件品名")
    private String ksh;

    /**
     * 快递单号
     */
    @Excel(name = "快递单号")
    private String kddh;

    /**
     * 姓名
     */
    @Excel(prompt = "姓名", name = "*收件人姓名")
    private String xm;

    /**
     * 邮政编码
     */
    @Excel(name = "收件人邮编", prompt = "邮政编码")
    private String yzbh;

    /**
     * 联系电话
     */
    @Excel(prompt = "联系电话", name = "*收件人电话/手机")
    private String lxdh;

    /**
     * 邮寄地址
     */
    @Excel(prompt = "邮寄地址", name = "*收件人地址")
    private String yjdz;

    /**
     * 数据状态
     */
    @Excel(name = "数据状态", dictType = "data_status")
    private Long status;

    @Excel(name = "备注")
    private String remark;

    @Override
    public String toString() {
        return "通知书快递数据{" +
                "考生号='" + ksh + '\'' +
                ", 快递单号='" + kddh + '\'' +
                ", 姓名='" + xm + '\'' +
                ", 邮件编码='" + yzbh + '\'' +
                ", 联系电话='" + lxdh + '\'' +
                ", 邮寄地址='" + yjdz + '\'' +
                ", 数据状态=" + status +
                ", 备注='" + remark + '\'' +
                '}';
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getKsh() {
        return ksh;
    }

    public void setKsh(String ksh) {
        this.ksh = ksh;
    }

    public String getKddh() {
        return kddh;
    }

    public void setKddh(String kddh) {
        this.kddh = kddh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getYzbh() {
        return yzbh;
    }

    public void setYzbh(String yzbh) {
        this.yzbh = yzbh;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getYjdz() {
        return yjdz;
    }

    public void setYjdz(String yjdz) {
        this.yjdz = yjdz;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

}
