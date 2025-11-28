public class TextBox extends UIControl {
    private String text = "";

    public TextBox() {
        super(true);
        System.out.println("TextBOx ");
    }

    public void setText(String text){
        this.text = text;

    }
    public void clear(){text="";}
}
