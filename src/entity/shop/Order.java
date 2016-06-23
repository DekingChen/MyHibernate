package entity.shop;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {
	private Long id;// ����
	private Customer customer;// �ͻ�
	private Date tradeDate;// ��������
	private String status;// ����״̬
	private Double amount;// �������
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();// ������ϸ

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", tradeDate="
				+ tradeDate + ", status=" + status + ", amount=" + amount + "]";
	}
	
}
