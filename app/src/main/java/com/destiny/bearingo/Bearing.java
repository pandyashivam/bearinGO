package com.destiny.bearingo;

public class Bearing {
    private String bearingNumber;
    private String ID;
    private String OD;
    private String Thick;
    private String Type;

    public Bearing(String bearingNumber, String ID, String OD, String thick ,String Type) {
        super();
        this.bearingNumber = bearingNumber;
        this.ID = ID;
        this.OD = OD;
        this.Thick = thick;
        this.Type = Type;
    }

    public String getBearingNumber() {
        return bearingNumber;
    }

    public void setBearingNumber(String bearingNumber) {
        this.bearingNumber = bearingNumber;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getOD() {
        return OD;
    }

    public void setOD(String OD) {
        this.OD = OD;
    }

    public String getThick() {
        return Thick;
    }

    public void setThick(String thick) {
        this.Thick = thick;
    }

    public String getType() {
        return Type;
    }

//    public void setType(String type) {
//        Type = type;
//    }
}
