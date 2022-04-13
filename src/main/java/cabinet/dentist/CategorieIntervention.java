package cabinet.dentist;

public class CategorieIntervention {
    private int IDcategorie;
    private String Type;
    private float PrixBase;

    public CategorieIntervention (int IDcategorie, String Type, float PrixBase ){
        this.IDcategorie = IDcategorie;
        this.Type = Type;
        this.PrixBase = PrixBase;
    }

    public int getIDcategorie(){
        return IDcategorie;
    }

    public void setIDcateforie( int IDcategorie){
        this.IDcategorie = IDcategorie;
    }

    public String getType(){
        return Type;
    }

    public void setType( String Type ){
        this.Type = Type;
    }

    public float getPrixBase(){
        return PrixBase;
    }

    public void setPrixBase( float PrixBase){
        this.PrixBase = PrixBase;
    }
}
