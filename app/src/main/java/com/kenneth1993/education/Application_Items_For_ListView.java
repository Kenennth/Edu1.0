package com.kenneth1993.education;

/**
 * Created by alfo06-24 on 2017-07-20.
 */

public class Application_Items_For_ListView {

    int img;
    String header;
    String contents;

    public Application_Items_For_ListView(int img, String header, String contents) {
        this.img = img;
        this.header = header;
        this.contents = contents;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
