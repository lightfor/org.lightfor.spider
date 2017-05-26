package org.lightfor.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * IP Location Info
 * Created by Light on 2017/5/26.
 */
public class IpAddress {

    public static void main(String[] args) throws IOException {
        String url = "http://www.ipip.net/ip.html";
        String ip = "8.8.8.8";
        Document doc = Jsoup.connect(url)
                .data("ip", ip)
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                .referrer(url)
                .post();
        System.out.println(doc.select("#myself").text());
    }
}
