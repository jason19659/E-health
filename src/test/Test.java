/**
 * 
 */
package test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

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
}
