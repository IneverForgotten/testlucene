package com.baizhi.util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;

public class LuceneUtil {
    private static Directory directory;
    private static Analyzer analyzer;
    private static IndexWriterConfig config;
    private static  final Version version=Version.LUCENE_44;
    static {
        try {
            directory=FSDirectory.open(new File("g:/index"));
            analyzer=new StandardAnalyzer(version);
            config=new IndexWriterConfig(version,analyzer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static IndexWriter getIndexWriter(){
        //创建索引写入器
        try {
            IndexWriter indexWriter = new IndexWriter(directory,config);
            return indexWriter;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static IndexSearcher getIndexSearcher(){
        try {
            IndexReader open = DirectoryReader.open(directory);
            IndexSearcher indexSearcher = new IndexSearcher(open);
            return indexSearcher;
        } catch (IOException e) {
            e.printStackTrace();
        }return null;

    }
}
