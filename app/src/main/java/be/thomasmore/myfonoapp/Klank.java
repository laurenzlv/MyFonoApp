package be.thomasmore.myfonoapp;

public class Klank {

    private int id;
    private String woord;
    private String afbeelding;
    private int paar;

    public Klank(){

    }

    public Klank(String woord, String afbeelding){
        this.afbeelding = afbeelding;
        this.woord = woord;
    }

    public Klank(String woord, String afbeelding, int paar){
        this.afbeelding = afbeelding;
        this.woord = woord;
        this.paar = paar;
    }

    public Klank(int id, String woord, String afbeelding, int paar){
        this.afbeelding = afbeelding;
        this.woord = woord;
        this.paar = paar;
        this.id = id;
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

    public int getPaar() {
        return paar;
    }

    public void setPaar(int paar) {
        this.paar = paar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
