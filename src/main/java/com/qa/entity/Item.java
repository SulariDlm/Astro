package com.qa.entity;

/**
 * Created by sulari.dulsara on 29/6/2018 .
 */
public class Item implements Comparable<Item> {
    private String name;
    private String link;
    private double price;
    private String webSite;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    @Override
    public String toString() {
        return "Item Details" + "<br>" +
                "<b> Name : </b>" + name + "<br>" +
                "<b> Link : </b>  <a>" + link + "</a><br>" +
                "<b> Price : </b>" + price + "<br>" +
                "<b> WebSite : </b><u>" + webSite + "</u><br>";
    }


    @Override
    public int compareTo(Item other) {
        return Double.compare(this.getPrice(), other.getPrice());
    }

}
