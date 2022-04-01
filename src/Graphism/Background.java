package Graphism;

import javafx.scene.image.Image;

public class Background {
    //Variables
    private Image Image;

    //Constructor
    public Background(int a){
        if (a == 1){
            this.Image = new Image("Resources/Sprites/fond Japonais.png");
        }
        else if (a == 2){
            this.Image = new Image("Resources/Sprites/fond fantasy.png");
        }
        else if (a == 3){
            this.Image = new Image("Resources/Sprites/fond.png");
        }
    }

    //GET
    public Image getImage() {
        return Image;
    }
}
