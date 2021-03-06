package quack.views.components;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ImageViewGrid extends GridPane {

    private ImageView[][] gridPaneArray;
    private int dimensions;

    public ImageViewGrid(int rows, int columns, int dimensions) {
        super();
        this.dimensions = dimensions;
        gridPaneArray = new ImageView[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                ImageView iv = new ImageView();
                iv.setFitHeight(dimensions);
                iv.setFitWidth(dimensions);
                gridPaneArray[r][c] = iv;
                this.add(iv, c, r);
            }
        }
    }

    public void setImage(Image image, int row, int col) {
        gridPaneArray[row][col].setImage(image);
    }

    public void clearImage(int row, int col) {
        gridPaneArray[row][col] = new ImageView();
        gridPaneArray[row][col].setFitHeight(dimensions);
        gridPaneArray[row][col].setFitHeight(dimensions);
    }
}
