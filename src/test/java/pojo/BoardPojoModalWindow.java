package pojo;

import java.util.Random;

public class BoardPojoModalWindow {
    public static final String TITLE = "some random title";
    private int randomVisibility ;

    public BoardPojoModalWindow(){
        setRandomVisibility();
    }

    private void setRandomVisibility(){
        randomVisibility = new Random().nextInt(3);
    }
}
