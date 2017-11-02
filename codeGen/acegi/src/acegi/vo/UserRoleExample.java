package acegi.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRoleExample extends UserRole {

    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public static final int EXAMPLE_IGNORE = 0;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public static final int EXAMPLE_NULL = 1;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public static final int EXAMPLE_NOT_NULL = 2;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public static final int EXAMPLE_EQUALS = 3;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public static final int EXAMPLE_NOT_EQUALS = 4;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public static final int EXAMPLE_GREATER_THAN = 5;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public static final int EXAMPLE_GREATER_THAN_OR_EQUAL = 6;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public static final int EXAMPLE_LESS_THAN = 7;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public static final int EXAMPLE_LESS_THAN_OR_EQUAL = 8;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public static final int EXAMPLE_LIKE = 9;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    private boolean combineTypeOr;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    private int roleId_Indicator;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    private int userId_Indicator;
    /**
     * This field was generated by Abator for iBATIS. This field corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    private int usetype_Indicator;

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public void setCombineTypeOr(boolean combineTypeOr) {
	this.combineTypeOr = combineTypeOr;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public boolean isCombineTypeOr() {
	return combineTypeOr;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public int getRoleId_Indicator() {
	return roleId_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public void setRoleId_Indicator(int roleId_Indicator) {
	this.roleId_Indicator = roleId_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public int getUserId_Indicator() {
	return userId_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public void setUserId_Indicator(int userId_Indicator) {
	this.userId_Indicator = userId_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public int getUsetype_Indicator() {
	return usetype_Indicator;
    }

    /**
     * This method was generated by Abator for iBATIS. This method corresponds to the database table user_role
     * @abatorgenerated  Wed Sep 24 23:16:28 CST 2008
     */
    public void setUsetype_Indicator(int usetype_Indicator) {
	this.usetype_Indicator = usetype_Indicator;
    }
}