package netTest.order.dto;

import netTest.order.vo.Custorder;

public class CustorderQuery extends Custorder {


	private String order_By_Clause;

	public CustorderQuery() {
		super();
	}

	public String getOrder_By_Clause() {
		return order_By_Clause;
	}

	public void setOrder_By_Clause(String order_By_Clause) {
		this.order_By_Clause = order_By_Clause;
	}


}
