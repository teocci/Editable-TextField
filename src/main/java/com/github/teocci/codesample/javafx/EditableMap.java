package com.github.teocci.codesample.javafx;

import com.github.teocci.codesample.javafx.lib.EditableDraggableText;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by teocci.
 *
 * @author teocci@yandex.com on 2017-Nov-14
 */
public class EditableMap extends Application
{
    private static final String MAP_IMAGE_LOC =
            "http://images.wikia.com/lotr/images/archive/f/f6/20130209175313!F27c_thorins_map_from_the_hobbit.jpg";

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        Pane pane = new Pane();

        pane.setOnMouseClicked(event -> {
            if (event.getTarget() == pane) {
                pane.getChildren().add(new EditableDraggableText(event.getX(), event.getY())
                );
            }
        });

        EditableDraggableText cssStyled = new EditableDraggableText(439, 253, "Style them with CSS");
        cssStyled.getStyleClass().add("highlighted");

        pane.getChildren().addAll(
                new EditableDraggableText(330, 101, "Click to add a label"),
                new EditableDraggableText(318, 225, "You can edit your labels"),
                cssStyled,
                new EditableDraggableText(336, 307, "And drag them"),
                new EditableDraggableText(309, 346, "Around The Lonely Mountain")
        );

        StackPane layout = new StackPane(
                new ImageView(
                        new Image(
                                MAP_IMAGE_LOC
                        )
                ),
                pane
        );

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("/css/editable-text.css").toExternalForm());

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}