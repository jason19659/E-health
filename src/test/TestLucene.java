/**
 * 
 */
package test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import javax.swing.text.Highlighter;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.NumberUtils;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.jason19659.ehealth.model.Medicinal;
import com.jason19659.ehealth.service.MedicinalService;
import com.jason19659.ehealth.service.OrderService;
import com.jason19659.ehealth.service.UserService;
import com.jason19659.ehealth.utils.LuceneUtil;
import com.jason19659.ehealth.utils.Property;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 *         test
 *
 *         2015年4月26日
 */
public class TestLucene {
	private static ApplicationContext context;
	private static UserService userService;
	private static OrderService orderService;
	private static MedicinalService ms;

	@BeforeClass
	public static void a() {
		context = new ClassPathXmlApplicationContext(new String[] {
				"classpath:spring-base.xml", "classpath:spring-mvc.xml",
				"classpath:spring-mybatis.xml" });
		userService = context.getBean(UserService.class);
		orderService = context.getBean(OrderService.class);
		ms = context.getBean(MedicinalService.class);
	}

	
	@Test
	public void go() throws Exception {
		createIndex();
		List<Medicinal> ms = search("4");
		for (Medicinal medicinal : ms) {
			System.out.println(medicinal);
		}
	}
	
	public void createIndex() throws Exception {
		LuceneUtil.deleteAllIndex();
		List<Medicinal> lms = ms.selectAll();
		List<Document> docs = new ArrayList<Document>();
		for (Medicinal m : lms) {
			Document doc = new Document();
			// 声明为NumericField的字段，只能用NumericRangeFilter对象范围查询，不能用作关键字查询。
			// NumericField不推荐，统一用Field

			doc.add(new StringField("id", m.getId(), Field.Store.YES));
			doc.add(new StringField("name", m.getName(), Field.Store.YES));
			doc.add(new StringField("type", m.getType(), Field.Store.YES));
			doc.add(new StringField("manu", m.getManufacturer(),
					Field.Store.YES));
			doc.add(new StringField("intro", m.getIntroduction(),
					Field.Store.YES));
			doc.add(new StringField("detail", m.getDetail(), Field.Store.YES));
			doc.add(new StringField("price", m.getPrice().toString(),
					Field.Store.YES));
			docs.add(doc);
		}
		LuceneUtil.createIndex(docs);
	}

	private List<Medicinal> search(String queryStr) {
		List<Medicinal> result = new ArrayList<Medicinal>();
		IndexSearcher searcher;
		try {
			String indexDir = TestLucene.class.getClassLoader().getResource("").toURI().getPath()+"search";
			String[] fields = { "id", "name", "type", "manu", "intro", "detail" };
			Occur[] occ = { Occur.SHOULD, Occur.SHOULD, Occur.SHOULD,
					Occur.SHOULD, Occur.SHOULD, Occur.SHOULD };
			Query query = MultiFieldQueryParser.parse(Version.LUCENE_40,
					queryStr, fields, occ, new IKAnalyzer());
			IndexReader reader = DirectoryReader.open(FSDirectory
					.open(new File(indexDir)));

			 searcher = new IndexSearcher(reader);
			TopDocs topDocs = searcher.search(query, 10000);
			int totalCount = Math.min(topDocs.totalHits, 10000);
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			for (ScoreDoc scDoc : scoreDocs) {
				Document document = searcher.doc(scDoc.doc);
				String id = document.get("id");
				String name = document.get("name");
				String type = document.get("type");
				String manu = document.get("manu");
				String intro = document.get("intro");
				String detail = document.get("detail");
				String price = document.get("price");

				Medicinal m = new Medicinal();
				m.setId(id);
				m.setName(name);
				m.setType(type);
				m.setManufacturer(manu);
				m.setIntroduction(intro);
				m.setDetail(detail);
				m.setPrice(new BigDecimal(price));
				result.add(m);
			}
			List<Medicinal> medicinals = new ArrayList<Medicinal>();
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return result;
	}
}
