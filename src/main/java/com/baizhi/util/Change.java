package com.baizhi.util;

import com.baizhi.entity.Shopping;
import org.apache.lucene.document.*;

public class Change {
    public static Document productToDocument(Shopping shopping){
        Document document = new Document();
        document.add(new StringField("name",shopping.getName(), Field.Store.YES));
        document.add(new DoubleField("price",shopping.getPrice(), Field.Store.YES));
        document.add(new StringField("src",shopping.getSrc(), Field.Store.YES));
        document.add(new TextField("descripe",shopping.getDescripe(), Field.Store.YES));
        return document;
    }

}
