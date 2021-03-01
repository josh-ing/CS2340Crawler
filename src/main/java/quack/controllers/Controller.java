package quack.controllers;

import javafx.stage.Stage;

/**
 * Controller super class. This class may not be needed since there
 * is not much to inherit but we will determine that later.
 */
public class Controller {

    protected Stage stage;

    /**
     * Default constructor
     */
    public Controller() {

    }

    /**
     * Constructor that initializes the controller with a stage
     * @param stage the stage initialized in QuackApp.java
     */
    public Controller(Stage stage) {
        this.stage = stage;
    }

}
