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

    private void setNome(String n){
        this.nome = n;
    }

    private void setPrecoP(float p){
        this.precoP = p;
    }
    
    private void setPrecoG(float g){
        this.precoG = g;
    }

    private void setDistancia(float d){
        this.distancia = d;
    }

    private void setAlt(boolean a){
        this.alt = a;
    }

    private void setAlt_precoP(float aP){
        this.alt_precoP = aP;
    }

    private void setAlt_precoG(float aG){
        this.alt_precoG = aG;
    }

    public String getNome(){
        return this.nome;
    }

    public float getPrecoP(){
        return this.precoP;
    }

    public float getPrecoG(){
        return this.precoG;
    }

    public float getDistancia(){
        return this.distancia;
    }

    public boolean getAlt(){
        return this.alt;
    }
    public float getAltPrecoP(){
        return this.alt_precoP;
    }

    public float getAltPrecoG(){
        return this.alt_precoG;
    }
}
