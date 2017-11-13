package cn.rongcapital.resume.mr;

import cn.rongcapital.resume.mr.model.Resume;
import lombok.extern.apachecommons.CommonsLog;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * 简历HTML文档解析器
 *
 * @author li.hzh 2017-11-13 11:10
 */
@CommonsLog
public class ResumeHTMLParser {

    public Resume parse(String htmlText) {
        if (htmlText == null || htmlText.isEmpty()) {
            log.info("Input resume is null or empty!!!");
            return null;
        }
        Document doc = null;
        try {
            doc = Jsoup.parse(htmlText);
        } catch (Exception e) {
            log.info("Invalid resume document, skip it.");
            return null;
        }
        Resume resume = new Resume();
        Element headElement = doc.head();
        parseHead(headElement, resume);
        System.out.println(doc.body());
        return resume;
    }

    private void parseHead(Element headElement, Resume resume) {
        Element titleElement = headElement.selectFirst("title");
        if (titleElement != null) {
            resume.setSource(titleElement.text());
        }
    }


}
