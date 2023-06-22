package BstStr;

public class Core {
    private String data;

    private Core left;
    private Core right;
    private int value;

    public Core(String data){
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public int getValue() {
        value = data.charAt(0);
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Core getLeft() {
        return this.left;
    }
    public Core getRight() {
        return this.right;
    }

    public void setLeft(Core core) {
        this.left = core;
    }
    public void setRight(Core core) {
        this.right = core;
    }
}
