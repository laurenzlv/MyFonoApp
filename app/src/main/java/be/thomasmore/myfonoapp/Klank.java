package be.thomasmore.myfonoapp;

public class Klank {

    private String woord;
    private String afbeelding;

    public Klank(){

    }

    public Klank(String woord, String afbeelding){
        this.afbeelding = afbeelding;
        this.woord = woord;
    }

    public String getAfbeelding() {
        return afbeelding;
    }

    public void setAfbeelding(String afbeelding) {
        this.afbeelding = afbeelding;
    }

    public String getWoord() {
        return woord;
    }

    public void setWoord(String woord) {
        this.woord = woord;
    }



}
