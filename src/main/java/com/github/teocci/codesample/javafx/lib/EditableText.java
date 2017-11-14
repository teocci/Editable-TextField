package com.github.teocci.codesample.javafx.lib;

import com.sun.javafx.tk.FontMetrics;
import com.sun.javafx.tk.Toolkit;
import javafx.application.Platform;
import javafx.scene.control.TextField;

/**
 * A text field which has no special decorations like background, border or focus ring.
 *   i.e. the EditableText just looks like a vanilla Text node or a Label node.
 * Created by teocci.
 *
 * @author teocci@yandex.com on 2017-Nov-14
 */
public class EditableText extends TextField
{
    // The right margin allows a little bit of space
    // to the right of the text for the editor caret.
    private final double RIGHT_MARGIN = 5;

    public EditableText(double x, double y) {
        relocate(x, y);
        getStyleClass().add("editable-text");

        //** CAUTION: this uses a non-public API (FontMetrics) to calculate the field size
        //            the non-public API may be removed in a future JavaFX version.
        // see: https://javafx-jira.kenai.com/browse/RT-8060
        //      Need font/text measurement API
        FontMetrics metrics = Toolkit.getToolkit().getFontLoader().getFontMetrics(getFont());
        setPrefWidth(RIGHT_MARGIN);
        textProperty().addListener((observable, oldTextString, newTextString) ->
                setPrefWidth(metrics.computeStringWidth(newTextString) + RIGHT_MARGIN)
        );

        Platform.runLater(this::requestFocus);
    }
}
