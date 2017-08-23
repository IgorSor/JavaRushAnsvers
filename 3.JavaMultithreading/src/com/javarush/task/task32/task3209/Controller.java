package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by MadHarry on 06.08.2017.
 */
public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }
    public static void main(String[] args){
        View view1 = new View();
        Controller controller = new Controller(view1);
        view1.setController(controller);
        view1.init();
        controller.init();
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void init(){
        createNewDocument();

    }
    public void exit(){
        System.exit(0);
    }
    public void resetDocument(){
        if(document != null){
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());

        view.update();
    }
    public void setPlainText(String text){
        resetDocument();
        StringReader reader = new StringReader(text);
        try {
            HTMLEditorKit kit = new HTMLEditorKit();
            kit.read(reader,document,0);
        } catch (IOException e) {
           ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }
    public String getPlainText(){
        StringWriter stringWriter = new StringWriter();
        HTMLEditorKit kit = new HTMLEditorKit();
        try {
            kit.write(stringWriter, document,0,document.getLength());

        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }


    public void openDocument() {
        view.selectHtmlTab();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        int answer = fileChooser.showOpenDialog(view);
        if(answer == JFileChooser.APPROVE_OPTION){
            try {
                currentFile = fileChooser.getSelectedFile();
                resetDocument();
                view.setTitle(currentFile.getName());
                FileReader fileReader = new FileReader(currentFile);
                new HTMLEditorKit().read(fileReader,document,0);
                view.resetUndo();
            } catch (FileNotFoundException|BadLocationException e) {
                ExceptionHandler.log(e);
            } catch (IOException e) {
                ExceptionHandler.log(e);
            }
        }



    }

    public void saveDocument() {
        view.selectHtmlTab();
        if(currentFile !=null){
            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                HTMLEditorKit kit = new HTMLEditorKit();
                kit.write(fileWriter, document, 0, document.getLength());
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }else saveDocumentAs();
    }

    public void saveDocumentAs() {

        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        int answer = fileChooser.showSaveDialog(view);
        if(answer == JFileChooser.APPROVE_OPTION ){
            currentFile = fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                HTMLEditorKit kit = new HTMLEditorKit();
                kit.write(fileWriter, document, 0, document.getLength());
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }

    }

    public void showAbout() {
    }
}
