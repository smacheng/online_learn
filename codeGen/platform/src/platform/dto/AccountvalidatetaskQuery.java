package platform.user.dto;

import platform.user.vo.Accountvalidatetask;
import commonTool.util.ObjUtil;

public class AccountvalidatetaskQuery extends Accountvalidatetask{

   private String order_By_Clause;

   public AccountvalidatetaskQuery() {
       super();
   }
   
   //public AccountvalidatetaskQuery(Accountvalidatetask vo) {
   //    super();
   //    ObjUtil.copyProperties(this, vo);
   //}

   public String getOrder_By_Clause() {
       return order_By_Clause;
   }

   public void setOrder_By_Clause(String order_By_Clause) {
       this.order_By_Clause = order_By_Clause;
   }
   
   //public void copyProperty(Accountvalidatetask vo){
   //   ObjUtil.copyProperties(this, vo);
   //}
   
}
