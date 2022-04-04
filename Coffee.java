// I want to be Diana's dog !
public class Coffee extends Product{
    private String origin;
    private String roast;
    private String favor;
    private String aroma;
    private String acidity;
    private String body;
    public Coffee(String initialCode, String initialDescription, double initialPrice,
	              String initialOrigin, String initialRoast, String initialFlavor,
                  String initialAroma, String initialAcidity, String initialBody){
        super(initialCode,initialDescription,initialPrice);
        this.origin = initialOrigin;
        this.roast = initialRoast;
        this.favor = initialFlavor;
        this.aroma = initialAroma;
        this.acidity = initialAcidity;
        this.body = initialBody;
    }

    public String getOrigin() {
        return origin;
    }

    public String getRoast() {
        return roast;
    }

    public String getFlavor() {
        return favor;
    }

    public String getAroma() {
        return aroma;
    }

    public String getAcidity() {
        return acidity;
    }

    public String getBody() {
        return body;
    }
    //Override toString
    public String toString(){
        return getCode() + "_" + getDescription() + "_" + getPrice() + "_" + origin + "_"
                + roast + "_" + favor + "_" + aroma + "_" + acidity + "_" + body;
    }
}
