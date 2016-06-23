package hibernate.hql;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.shop.Commodity;
import entity.shop.Customer;
import entity.shop.Order;
import entity.shop.OrderItem;
import entity.shop.Seller;
import hibernate.util.HibernateUtil;

public class Client {

	public static String sql = null;
	public static Query query = null;
	public static Session session = null;


	public static void init() {
		session = HibernateUtil.getSession();
	}

	public static void destroy() {
		HibernateUtil.closeSession(session);
	}

	// 通过商家查询商品信息
	public static void querySeller() {
		sql = "from Seller";
		query = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Seller> sellers = query.list();
		for (Seller seller : sellers) {
			System.out.println(seller.toString());
			//System.out.println(seller.getCommodities());
		}
	}

	// 通过商品信息查询商家
	public static void queryCommodity() {
		sql = "from Commodity";
		query = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Commodity> commodities = query.list();
		for (Commodity com : commodities) {
			System.out.println(com.toString() + "Seller:"
					+ com.getSeller().toString());
		}
	}

	// 通过客户查询订单信息
	public static void quereyCustomer() {
		sql = "from Customer";
		query = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Customer> customers = query.list();
		for (Customer customer : customers) {
			System.out.println("customer information:"+customer.toString());
			/*Set<Order> orders = customer.getOrders();
			
			Iterator<Order> it = orders.iterator();
		       while(it.hasNext()){
		    	   Order order = it.next();
		    	   System.out.println("order information:"+order.toString());
		          }
		       System.out.println("====================================================");*/

		}
	}

	// 查询订单详情
	public static void queryOrder() {
		sql = "from Order as order";
		query = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Order> orders = query.list();
		for (Order order : orders) {
			System.out.print(order);
			//System.out.print(order.toString());
		}
	}

	// 查询订单明细
	public static void queryOrderItem() {
		sql = "from OrderItem as item";
		query = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<OrderItem> orders = query.list();
		for (OrderItem order : orders) {
			//System.out.print(order);
			System.out.println(order.toString());
			//System.out.println(order.getOrder().toString());
		}
	}
	
	//测试查询数据返回的类型
	public static void queryReturn(){
		sql = "select new map(s.name as name,s.tel as tel,s.address as address)from Seller as s ";//以map形式返回结果
		query = session.createQuery(sql);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Map> sellers = query.list();
		for (Map<?, ?> seller : sellers) {
			System.out.println("seller name=="+seller.get("name"));
		}
		
		sql = " select new list(s.name,s.tel,s.address) from Seller s ";//以list形式返回结果
		query = session.createQuery(sql);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<List> sellerss = query.list();
		for(@SuppressWarnings("rawtypes") List list : sellerss){
			System.out.println("name : "+list.get(0));
			System.out.println("tel:"+list.get(1));
			System.out.println("address:"+list.get(2));
		}
	}
	
	public static void queryWhere(){
		sql = "from Commodity c where c.price>400";
		query = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Commodity> commodities = query.list();
		for (Commodity com : commodities) {
			System.out.println(com.toString() + "Seller:"
					+ com.getSeller().toString());
		}
	}
	
	public static void queryCollection(){
		sql = "select Order o where o.orderItems is not empty";
		query = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<OrderItem> orders = query.list();
		for (OrderItem order : orders) {
			//System.out.print(order);
			System.out.println(order.toString());
			//System.out.println(order.getOrder().toString());
		}
	}
	
	public static void queryOnly(){
		sql  = "from Customer as c where c.name='张三'" ;
		query = session.createQuery(sql);
		Customer c = (Customer) query.uniqueResult();
		System.out.print(c.toString());
	}
	
	public static void queryOrderBy(){
		sql = "from Commodity c order by price asc";
		query = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Commodity> commodities = query.list();
		for (Commodity com : commodities) {
			System.out.println(com.toString() + "Seller:"
					+ com.getSeller().toString());
		}
	}
	
	public static void main(String args[]) {

		init();// 初始化session连接

		//querySeller();
		//queryCommodity();
		//quereyCustomer();
		queryOrder();
		//queryOrderItem();
		//queryReturn();
		//queryWhere();
		//queryCollection();
		//queryOnly();
		//queryOrderBy();
		
		destroy();// 释放session资源
	}
}
