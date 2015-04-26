/**
 * 
 */
package test;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jason19659.ehealth.model.Order;
import com.jason19659.ehealth.service.OrderService;
import com.jason19659.ehealth.service.UserService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.ehealth.test
 *
 * 2015年4月16日
 */
public class Test {
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString().length());
		BigDecimal b = new BigDecimal("2.11");
		System.out.println(b);
	}
	
	private static ApplicationContext context;
	private static UserService userService;
	private static OrderService orderService;
	@BeforeClass
	public static void a() {
		context = new ClassPathXmlApplicationContext(new String[]{ "classpath:spring-base.xml","classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"});
		userService = context.getBean(UserService.class);
		orderService = context.getBean(OrderService.class);
	}
	
	@org.junit.Test
	public void test2() {
		String id = UUID.randomUUID().toString();
		Order o = new Order();
		o.setId(id);
		o.setOrderId(id);
		o.setUserId(id);
		o.setPrice(new BigDecimal(11));
		orderService.insert(o);
	}
	
	@org.junit.Test
	public void test3() {
		
		System.out.println(orderService.selectAll().size());
	}
	
	@org.junit.Test
	public void test() {
		System.out.println(111);
		System.out.println(userService.selectByUsername("jason").getComptence());
	}
}
