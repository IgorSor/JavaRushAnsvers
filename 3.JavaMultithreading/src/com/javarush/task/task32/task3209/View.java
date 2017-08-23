package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by MadHarry on 06.08.2017.
 */
public class View extends JFrame  implements ActionListener{
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public Controller getController() {
        return controller;
    }


    public View()  {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String action = actionEvent.getActionCommand();
        switch (action){
            case "Новый":controller.createNewDocument();break;
            case "Открыть":controller.openDocument();break;
            case "Сохранить":controller.saveDocument();break;
            case "Сохранить как...":controller.saveDocumentAs();break;
            case "Выход":controller.exit();break;
            case "О программе":showAbout();break;
        }
    }
    public void init(){
        initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);

    }
    public void exit(){
        controller.exit();
    }
    public void initMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        MenuHelper menuHelper = new MenuHelper();
        menuHelper.initFileMenu(this, menuBar);
        menuHelper.initEditMenu(this, menuBar);
        menuHelper.initStyleMenu(this, menuBar);
        menuHelper.initAlignMenu(this, menuBar);
        menuHelper.initColorMenu(this, menuBar);
        menuHelper.initFontMenu(this, menuBar);
        menuHelper.initHelpMenu(this, menuBar);
        getContentPane().add(menuBar, BorderLayout.NORTH);

    }
    public void initEditor(){
        htmlTextPane.setContentType("text/html");
        JScrollPane scrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", scrollPane);
        JScrollPane secondScrollPane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", secondScrollPane);
        tabbedPane.setPreferredSize(new Dimension(640,480));
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }
    public boolean canUndo(){
        return undoManager.canUndo();
    }
    public boolean canRedo(){
        return undoManager.canRedo();
    }
    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() ==0;
    }
    public void undo(){
        try{ undoManager.undo();

        }catch (CannotUndoException e){ExceptionHandler.log(e);}
    }
    public void redo(){
        try{
            undoManager.redo();

        }catch (CannotRedoException e){ExceptionHandler.log(e);}
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void setUndoListener(UndoListener undoListener) {
        this.undoListener = undoListener;
    }
    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    public void selectedTabChanged(){
        if(tabbedPane.getSelectedIndex() == 0){
            controller.setPlainText(plainTextPane.getText());
        }else if(tabbedPane.getSelectedIndex() == 1){
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();

    }
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }
    public void showAbout(){
        JOptionPane.showMessageDialog(tabbedPane.getSelectedComponent(),"This program is written by MadHarry", "About",JOptionPane.INFORMATION_MESSAGE);
    }

}
