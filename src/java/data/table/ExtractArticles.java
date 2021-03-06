/*
 * The MIT License
 *
 * Copyright 2015 Jones.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package data.table;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Jones
 */
public class ExtractArticles {
    
    public static String extract(String link){
        
        return removeStyle(toExtract(link));
    }
    
    
    private static String toExtract(String link){
        String article = "";
        try {
            Document doc = Jsoup.connect(link).get();
            Element body = doc.body();
            article = body.toString();            
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
        return article;
    }
    
     private static String removeStyle(String body) {
        String[] s = body.split("style\\s*=\\s*((\".+\")|('.+'))");
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < s.length; ++i) {
            builder.append(s[i]);
        }
        
        return builder.toString();
    }
}
