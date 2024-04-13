package com.baidu.nlp;

import java.util.ArrayList;
import java.util.List;

public class ChineseSegmenter {
    private final LAC lac;
    public ChineseSegmenter(){
        this("lac_model");
    }
    public ChineseSegmenter(String modelPath){
        lac=new LAC(modelPath);
    }
    public List<List<String>> run(String query){
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> tags = new ArrayList<>();
        lac.run(query, words, tags);
        List<List<String>> result=new ArrayList<>();
        result.add(words);
        result.add(tags);
        return result;
    }
    public int run(String query, List<String> words, List<String> tags){
        ArrayList<String> wordsArray = new ArrayList<>();
        ArrayList<String> tagsArray = new ArrayList<>();
        int res=lac.run(query, wordsArray, tagsArray);
        words.addAll(wordsArray);
        tags.addAll(tagsArray);
        return res;
    }
    static {
        System.loadLibrary("lacjni");
    }
}
