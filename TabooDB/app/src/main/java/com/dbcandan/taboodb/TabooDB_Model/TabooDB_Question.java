package com.dbcandan.taboodb.TabooDB_Model;


public class TabooDB_Question {
    private String questionText;
    private String forbiddenText1;
    private String forbiddenText2;
    private String forbiddenText3;
    private String forbiddenText4;
    private String forbiddenText5;

    public TabooDB_Question(String v_questionText, String v_forbiddenText1, String v_forbiddenText2, String v_forbiddenText3, String v_forbiddenText4, String v_forbiddenText5) {
        setQuestionText(v_questionText);
        setForbiddenText1(v_forbiddenText1);
        setForbiddenText2(v_forbiddenText2);
        setForbiddenText3(v_forbiddenText3);
        setForbiddenText4(v_forbiddenText4);
        setForbiddenText5(v_forbiddenText5);
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getForbiddenText1() {
        return forbiddenText1;
    }

    public void setForbiddenText1(String forbiddenText1) {
        this.forbiddenText1 = forbiddenText1;
    }

    public String getForbiddenText2() {
        return forbiddenText2;
    }

    public void setForbiddenText2(String forbiddenText2) {
        this.forbiddenText2 = forbiddenText2;
    }

    public String getForbiddenText3() {
        return forbiddenText3;
    }

    public void setForbiddenText3(String forbiddenText3) {
        this.forbiddenText3 = forbiddenText3;
    }

    public String getForbiddenText4() {
        return forbiddenText4;
    }

    public void setForbiddenText4(String forbiddenText4) {
        this.forbiddenText4 = forbiddenText4;
    }

    public String getForbiddenText5() {
        return forbiddenText5;
    }

    public void setForbiddenText5(String forbiddenText5) {
        this.forbiddenText5 = forbiddenText5;
    }
}
