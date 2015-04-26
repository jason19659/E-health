/**
 * 
 */
package com.jason19659.ehealth.service;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;

import test.TestLucene;

import com.jason19659.ehealth.model.Medicinal;
import com.jason19659.ehealth.utils.LuceneUtil;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.ehealth.service
 *
 * 2015年4月26日
 */
@Service
public class LuceneService {
	
	@Autowired
	private MedicinalService ms ;
	
	public void createIndex() {
		LuceneUtil.deleteAllIndex();
		List<Medicinal> lms = ms.selectAll();
		List<Document> docs = new ArrayList<Document>();
		for (Medicinal m : lms) {
			Document doc = new Document();
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
	
	public List<Medicinal> search(String queryStr) {
		List<Medicinal> result = new ArrayList<Medicinal>();
		List<Medicinal> resultList = null;
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

				Medicinal m = new Medicinal();
				m.setId(id);
				m.setName(name);
				m.setType(type);
				m.setManufacturer(manu);
				m.setIntroduction(intro);
				m.setDetail(detail);
				result.add(m);
			}
			resultList = new ArrayList<Medicinal>(result.size());
			for (Medicinal medicinal :result) {
				resultList.add(ms.selectByPrimaryKey(medicinal.getId())) ;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return resultList;
	}
}
