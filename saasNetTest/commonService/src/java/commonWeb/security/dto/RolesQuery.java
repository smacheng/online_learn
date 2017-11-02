package commonWeb.security.dto;

import commonWeb.security.vo.Roles;


public class RolesQuery extends Roles{
   
   private String rolecodeStr;
	
   private String order_By_Clause;

   public RolesQuery() {
       super();
   }

   public String getOrder_By_Clause() {
       return order_By_Clause;
   }

   public void setOrder_By_Clause(String order_By_Clause) {
       this.order_By_Clause = order_By_Clause;
   }

	public String getRolecodeStr() {
		return rolecodeStr;
	}

	public void setRolecodeStr(String rolecodeStr) {
		this.rolecodeStr = rolecodeStr;
	}
	
}
