package com.pt.order.vo;
/**封装排序条件*/
public class SqlOrderCommand {
    /**字段名*/
	private String column;
	/**排序类型(desc/asc)*/
	private String type;
	
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
