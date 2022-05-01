package cabinet.dentist;

public class TypeRadio {
    private String IDTypeRadio;
    private String Description;

    public TypeRadio (String IDTypeRadio, String Description){
        this.IDTypeRadio = IDTypeRadio;
        this.Description = Description;
    }

    public String getIDTypeRadio(){
        return IDTypeRadio;
    }

    public void setIDTypeRadio(){
        this.IDTypeRadio = IDTypeRadio;
    }

    public String getDescription(){
        return Description;
    }

    public void setDescription(){
        this.Description = Description;
    }
}
