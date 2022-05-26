package com.example.lab5;

import com.example.lab5.books.BookFactory;
import com.example.lab5.books.ReadingBook;
import com.example.lab5.books.Book;
import com.example.lab5.books.EnglishTextbook;
import com.example.lab5.books.EnglishFiction;
import com.example.lab5.books.RussianFiction;
import com.example.lab5.users.User;
import com.example.lab5.users.ReadingUser;
import com.example.lab5.users.UserFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.FileChooser;
import java.io.File;
import java.util.ArrayList;

public class Controller {

    ArrayList<User> users = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();

    @FXML
    private TreeView<String> tree;

    @FXML
    private Button buttonUser;
    private Button buttonTree;

   /* public void initialize(){
        buttonUser.setDisable(true);

    }*/

    public static void error(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }

    @FXML
    void ReadingBook(ActionEvent event) {
        try {
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("C:\\Users\\user\\IdeaProjects\\F\\Laba5.2"));//\lab5-1.0\src\main\resources\com\example\lab5
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel", "*.xlsx");
            fc.getExtensionFilters().add(extFilter);
            File file = fc.showOpenDialog(null);
            ReadingBook readingBook = new ReadingBook();
            readingBook.Readingbook(file);

            BookFactory bookFactory = new BookFactory(readingBook);

           // buttonUser.setDisable(false);

            for (int i = 0; i < 500; i++) {
                books.add(bookFactory.createBook());
            }

        } catch (Exception e) {
            error(e);
        }
    }

    @FXML
    void ReadingUser(ActionEvent event) {
        try {
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("C:\\Users\\user\\IdeaProjects\\F\\Laba5.2"));
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel", "*.xlsx");
            fc.getExtensionFilters().add(extFilter);
            File file = fc.showOpenDialog(null);
            ReadingUser impU = new ReadingUser();
            impU.Readingus(file);

            UserFactory userFactory = new UserFactory(impU);

            for (int i = 0; i < 150; i++) {
                users.add(userFactory.createUser(books));
            }

           // buttonTree.setDisable(false);

        } catch (Exception e) {
            error(e);
        }
    }

    @FXML
    void Showtree(ActionEvent event) {
        try {

            initializeTree();

        } catch (Exception e) {
            error(e);
        }
    }

    @FXML
    void Exit(ActionEvent event) {
       System.exit(0);
    }

    public void initializeTree() {

        int StudentNumber = 0;
        int TeacherNumber = 0;

        TreeItem<String> rootItem = new TreeItem<>("Пользователи. Каф. 71, 72, 82");
        rootItem.setExpanded(true);
        TreeItem<String> studentBranchItem = new TreeItem<>();
        rootItem.getChildren().add(studentBranchItem);
        TreeItem<String> teacherBranchItem = new TreeItem<>();
        rootItem.getChildren().add(teacherBranchItem);

        for (User user : users) {

         TreeItem<String> branchItem = new TreeItem<>(user.getFullName() + " (" + user.getBooks().size() + ")");
            if (user.getClass().getName().equals("com.example.lab5.users.Student")) {
                studentBranchItem.getChildren().add(branchItem);
                StudentNumber++;

         } else {
                teacherBranchItem.getChildren().add(branchItem);
                TeacherNumber++;
            }

           user.getBooks().forEach((obj) -> {
                Book book = (Book) obj;

                TreeItem<String> bookItem = new TreeItem<>(book.getName());
                branchItem.getChildren().add(bookItem);
                bookItem.getChildren().add(new TreeItem<>("Тип : " + book.getType()));
                bookItem.getChildren().add(new TreeItem<>("Язык : " + book.getLanguage()));

                if (book.getClass().getName().equals("com.example.lab5.books.EnglishTextbook")) {
                    EnglishTextbook b = (EnglishTextbook) book;
                    bookItem.getChildren().add(new TreeItem<>("Автор : " + b.getAuthor()));
                    bookItem.getChildren().add(new TreeItem<>("Университет : " + b.getUniversity()));
                    bookItem.getChildren().add(new TreeItem<>("Уровень : " + b.getLеvеl()));

                } else if (book.getClass().getName().equals("com.example.lab5.books.EnglishFiction")) {
                    EnglishFiction b = (EnglishFiction) book;
                    bookItem.getChildren().add(new TreeItem<>("Автор : " + b.getAuthor()));

                } else if (book.getClass().getName().equals("com.example.lab5.books.RussianFiction")) {
                    RussianFiction b = (RussianFiction) book;
                    bookItem.getChildren().add(new TreeItem<>("Автор : " + b.getAuthor()));
                    bookItem.getChildren().add(new TreeItem<>("Год издания : " + b.getYear()));
                }


            });

        }

        studentBranchItem.setValue("Студенты (" + StudentNumber + ")");
        teacherBranchItem.setValue("Преподаватели (" + TeacherNumber + ")");

        tree.setRoot(rootItem);

    }

}
