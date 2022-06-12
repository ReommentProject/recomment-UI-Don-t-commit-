package com.example.recommentflowchartui;

public class CategoryData {

    private int star;
    private String cname;

    public CategoryData(int star, String cname) {
        this.star = star;
        this.cname = cname;

    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getName() {
        return cname;
    }

    public void setName(String cname) {
        this.cname = cname;
    }

}
