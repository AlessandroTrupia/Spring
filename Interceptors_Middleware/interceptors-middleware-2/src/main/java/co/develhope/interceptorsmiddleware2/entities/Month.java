package co.develhope.interceptorsmiddleware2.entities;

public class Month {


    private Integer monthNumber;
    private String enlgishName;
    private String italianName;
    private String germanName;

    public Month() {
    }

    public Month(int monthNumber, String enlgishName, String italianName, String germanName) {
        this.monthNumber = monthNumber;
        this.enlgishName = enlgishName;
        this.italianName = italianName;
        this.germanName = germanName;
    }

    public Integer getMonthNumber() {
        return monthNumber;
    }

    public String getEnlgishName() {
        return enlgishName;
    }

    public String getItalianName() {
        return italianName;
    }

    public String getGermanName() {
        return germanName;
    }
}