package com.baizhi.dao;

import com.baizhi.entity.Shopping;
import com.baizhi.util.Change;
import com.baizhi.util.LuceneUtil;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingDaoImpl implements ShoppingDao {
    @Override
    public void insertDB(Shopping shopping) {
        try {
            IndexWriter indexWriter = LuceneUtil.getIndexWriter();
            Document document = Change.productToDocument(shopping);
            indexWriter.addDocument(document);
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Shopping> qeuryIndex(String s) {
        try {
            List<Shopping> list = new ArrayList<>();
            IndexSearcher indexSearcher = LuceneUtil.getIndexSearcher();
            Query query =new TermQuery(new Term("descripe",s));
            //你要查多少数据
            TopDocs search = indexSearcher.search(query, 100);
            ScoreDoc[] scoreDocs = search.scoreDocs;
            for (ScoreDoc scoreDoc : scoreDocs) {
                Shopping ss = new Shopping();
                int doc = scoreDoc.doc;
                Document doc1 = indexSearcher.doc(doc);
                ss.setName(doc1.get("name"));
                ss.setPrice(Double.parseDouble(doc1.get("price")));
                ss.setSrc(doc1.get("src"));
                ss.setDescripe(doc1.get("descripe"));

                list.add(ss);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
