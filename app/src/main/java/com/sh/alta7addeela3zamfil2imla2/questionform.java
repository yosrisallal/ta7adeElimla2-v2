package com.sh.alta7addeela3zamfil2imla2;

public class questionform {
    String false1, false2, false3, lamp, leson, question, right;
    String category;

    public questionform() {
    }

    public questionform(String false1, String false2, String false3, String leson, String question,String lamp, String right, String category) {
        this.false1 = false1;
        this.false2 = false2;
        this.false3 = false3;
        this.leson = leson;
        this.question = question;
        this.right = right;
        this.lamp=lamp;
        this.category = category;}

    public String getFalse1() {
        return false1;
    }

    public void setFalse1(String false1) {
        this.false1 = false1;
    }

    public String getFalse2() {
        return false2;
    }

    public void setFalse2(String false2) {
        this.false2 = false2;
    }

    public String getFalse3() {
        return false3;
    }

    public void setFalse3(String false3) {
        this.false3 = false3;
    }


    public String getLeson() {
        return leson;
    }

    public String getLamp() {
        return lamp;
    }

    public void setLamp(String lamp) {
        this.lamp = lamp;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLeson(String leson) {
        this.leson = leson;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getcategory() {
        return category;
    }

    public void setcategory(String category) {
        this.category = category;
    }

}
