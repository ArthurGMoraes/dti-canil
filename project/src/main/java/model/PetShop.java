package model;

public class PetShop {
    private String nome;
    private float precoP;
    private float precoG;
    private float distancia;
    private boolean alt;
    private float alt_precoP;
    private float alt_precoG;

    public PetShop(){
        this("", 0.0f, 0.0f, 0.0f, false, 0.0f, 0.0f);
    }

    public PetShop (String n, float p, float g, float d){
        this(n, p, g, d, false, 0.0f, 0.0f);
    }

    public PetShop (String n, float p, float g, float d, float aP, float aG){
        this(n, p, g, d, true, aP, aG);
    }

    public PetShop(String n, float p, float g, float d, boolean a, float aP, float aG){
        setNome(n);
        setPrecoP(p);
        setPrecoG(g);
        setDistancia(d);
        setAlt(a);
        setAlt_precoP(aP);
        setAlt_precoG(aG);
    }

    void setNome(String n){
        this.nome = n;
    }

    void setPrecoP(float p){
        this.precoP = p;
    }
    
    void setPrecoG(float g){
        this.precoG = g;
    }

    void setDistancia(float d){
        this.distancia = d;
    }

    void setAlt(boolean a){
        this.alt = a;
    }

    void setAlt_precoP(float aP){
        this.alt_precoP = aP;
    }

    void setAlt_precoG(float aG){
        this.alt_precoG = aG;
    }

    String getNome(){
        return this.nome;
    }

    float getPrecoP(){
        return this.precoP;
    }

    float getPrecoG(){
        return this.precoG;
    }

    float getDistancia(){
        return this.distancia;
    }

    boolean getAlt(){
        return this.alt;
    }
    float getAltPrecoP(){
        return this.alt_precoP;
    }

    float getAltPrecoG(){
        return this.alt_precoG;
    }
}
