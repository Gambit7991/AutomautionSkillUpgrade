package pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

public class BoardPojoModalWindow {
    public static final String TITLE = "some random title";
    private int randomVisibility ;

    public BoardPojoModalWindow(){
        setRandomVisibility();
    }

    // Delete random staff
    private void setRandomVisibility(){
        randomVisibility = new Random().nextInt(3);
    }
}

@Getter
@Setter
class Board {
    String name;
}
