package com.rpham64.android.antsquaretask.Model;

import java.util.List;

/**
 * Class representation of the JSON Hierarchy provided
 *
 * Note: JSONObjects = member variable, JSONArrays = new class
 *
 * Created by Rudolf on 6/5/2016.
 */
public class AntsquareJSON {

    private boolean has_more;
    private Integer pages;
    private Integer page;
    private Integer per_page;
    private List<Cards> cards;

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public List<Cards> getCards() {
        return cards;
    }

    public void setCards(List<Cards> cards) {
        this.cards = cards;
    }
}

