package acegi.dto;

import acegi.vo.Users;

public class UsersQuery extends Users{

   private String order_By_Clause;

   public UsersQuery() {
       super();
   }

   public String getOrder_By_Clause() {
       return order_By_Clause;
   }

   public void setOrder_By_Clause(String order_By_Clause) {
       this.order_By_Clause = order_By_Clause;
   }
}
