package cabinet.dentist;

public class TypeRadio {
    private int IDTypeRadio;
    private String Description;

    public TypeRadio (int IDTypeRadio, String Description){
        this.IDTypeRadio = IDTypeRadio;
        this.Description = Description;
    }

    public int getIDTypeRadio(){
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
