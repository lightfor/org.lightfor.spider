package org.lightfor.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * IP Location Info
 * Created by Light on 2017/5/26.
 */
public class IpAddress {

    public static void main(String[] args) throws IOException {
        String url = "http://www.ipip.net/ip.html";
        String ipStr = "8.8.8.8\n" +
                "8.8.4.4\n";
        String[] ips = ipStr.split("\n");

        //Proxy proxy = new Proxy( Proxy.Type.HTTP, InetSocketAddress.createUnresolved("127.0.0.1", 1080) );

        //2. set system properties, not recommend
        //System.getProperties().setProperty("http.proxyHost", "127.0.0.1");
        //System.getProperties().setProperty("http.proxyPort", "1080");
        for(String ip : ips){
            Document doc = Jsoup.connect(url)
                    .timeout(10000)
                    //.proxy(proxy)
                    .data("ip", ip)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer(url)
                    .post();
            System.out.println(doc.select("#myself").text());
        }
    }
}
