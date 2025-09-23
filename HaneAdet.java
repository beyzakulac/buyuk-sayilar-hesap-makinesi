public class HaneAdet {
    private int _tamadet;
    private int _ondalikadet;

    public HaneAdet(int tamadet, int ondalikadet) {
        if (tamadet > 0)
        {
            this._tamadet = tamadet;        
        } else {
            this._tamadet = 1;
        }
        if (ondalikadet >= 0)
        {
            this._ondalikadet = ondalikadet;        
        } else {
            this._ondalikadet = 0;
        }
    }

    public int getTamAdet() {
        return this._tamadet;
    }

    public void setTamAdet(int tamadet) {
        if (tamadet > 0)
        {
            this._tamadet = tamadet;        
        }
    } 
    
    public int getOndalikAdet() {
        return this._ondalikadet;
    }

    public void setOndalikAdet(int ondalikadet) {
        if (ondalikadet >= 0)
        {
            this._ondalikadet = ondalikadet;        
        }
    }     
}