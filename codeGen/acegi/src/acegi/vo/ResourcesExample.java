package acegi.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourcesExample extends Resources {

    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public static final int EXAMPLE_IGNORE = 0;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public static final int EXAMPLE_NULL = 1;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public static final int EXAMPLE_NOT_NULL = 2;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public static final int EXAMPLE_EQUALS = 3;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public static final int EXAMPLE_NOT_EQUALS = 4;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public static final int EXAMPLE_GREATER_THAN = 5;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public static final int EXAMPLE_GREATER_THAN_OR_EQUAL = 6;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public static final int EXAMPLE_LESS_THAN = 7;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public static final int EXAMPLE_LESS_THAN_OR_EQUAL = 8;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public static final int EXAMPLE_LIKE = 9;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    private boolean combineTypeOr;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    private int id_Indicator;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    private int name_Indicator;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    private int resType_Indicator;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    private int resString_Indicator;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    private int syscode_Indicator;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    private int upid_Indicator;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    private int ordno_Indicator;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    private int status_Indicator;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    private int descn_Indicator;

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public void setCombineTypeOr(boolean combineTypeOr) {
	this.combineTypeOr = combineTypeOr;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public boolean isCombineTypeOr() {
	return combineTypeOr;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public int getId_Indicator() {
	return id_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public void setId_Indicator(int id_Indicator) {
	this.id_Indicator = id_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public int getName_Indicator() {
	return name_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public void setName_Indicator(int name_Indicator) {
	this.name_Indicator = name_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public int getResType_Indicator() {
	return resType_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public void setResType_Indicator(int resType_Indicator) {
	this.resType_Indicator = resType_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public int getResString_Indicator() {
	return resString_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public void setResString_Indicator(int resString_Indicator) {
	this.resString_Indicator = resString_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public int getSyscode_Indicator() {
	return syscode_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public void setSyscode_Indicator(int syscode_Indicator) {
	this.syscode_Indicator = syscode_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public int getUpid_Indicator() {
	return upid_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public void setUpid_Indicator(int upid_Indicator) {
	this.upid_Indicator = upid_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public int getOrdno_Indicator() {
	return ordno_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public void setOrdno_Indicator(int ordno_Indicator) {
	this.ordno_Indicator = ordno_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public int getStatus_Indicator() {
	return status_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public void setStatus_Indicator(int status_Indicator) {
	this.status_Indicator = status_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public int getDescn_Indicator() {
	return descn_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table resources
     * @abatorgenerated  Wed Sep 24 23:16:27 CST 2008
     */
    public void setDescn_Indicator(int descn_Indicator) {
	this.descn_Indicator = descn_Indicator;
    }
}