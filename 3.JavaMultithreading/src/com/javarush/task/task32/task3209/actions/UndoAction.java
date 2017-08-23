package com.javarush.task.task32.task3209.actions;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by MadHarry on 06.08.2017.
 */
public class UndoAction extends AbstractAction {
    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    private View view;
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        view.undo();

    }

    /**
     * Creates an {@code Action}.
     */
    public UndoAction(View view) {
        this.view = view;
    }
}
