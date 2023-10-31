import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JFrame {
    JList<String> JListBook, JListMagazine;
    Label textSearchLabel;
    JTextField textSearch;
    List<String> bookArrayList = new ArrayList<String>();
    List<String> magazineArrayList = new ArrayList<String>();
    CheckboxGroup checkboxGroup;
    Checkbox checkboxBook, checkboxMagazine;
    JButton button;
    Panel() {
        super("Пробное окно");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        textSearchLabel = new Label("Введите поисковый текст");
        textSearch = new JTextField();
        checkboxGroup = new CheckboxGroup();
        checkboxBook = new Checkbox("Книги", checkboxGroup, false);
        checkboxMagazine = new Checkbox("Журналы", checkboxGroup, false);
        button = new JButton("Найти");

        bookArrayList.add("Преступление и наказание");
        bookArrayList.add("Великий Гэтсби");
        bookArrayList.add("Ворота Расемон");
        bookArrayList.add("Маленькие женщины");
        bookArrayList.add("Убийства по алфавиту");
        magazineArrayList.add("Cosmopolitan");
        magazineArrayList.add("Истории");
        magazineArrayList.add("Glamour");
        magazineArrayList.add("People");
        magazineArrayList.add("Антенна-Телесемь");
        DefaultListModel<String> modelBook = new DefaultListModel<String>();
        for (String item : bookArrayList) {
            modelBook.addElement(item);
        }
        JListBook = new JList<>(modelBook);
        DefaultListModel<String> modelMagazine = new DefaultListModel<String>();
        for (String item : magazineArrayList) {
            modelMagazine.addElement(item);
        }
        JListMagazine = new JList<>(modelMagazine);

        setLayout(null);
        JListBook.setBounds(10, 10, 150, 110);
        JListMagazine.setBounds(190, 10, 150, 110);
        checkboxBook.setBounds(370, 40, 100, 20);
        checkboxMagazine.setBounds(370, 60, 100, 20);
        textSearchLabel.setBounds(130, 150, 200, 25);
        textSearch.setBounds(130, 180, 200, 50);
        button.setBounds(180, 250, 70, 25);
        add(textSearchLabel);
        add(textSearch);
        add(JListBook);
        add(JListMagazine);
        add(checkboxBook);
        add(checkboxMagazine);
        add(button);
        button.addActionListener(click);
    }
    ActionListener click = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            List<String> findList = new ArrayList<>();
            JListBook.clearSelection();
            JListMagazine.clearSelection();
            if (checkboxBook.getState()) {
                findList = User.searchText(bookArrayList, textSearch);
                if (findList.isEmpty()) { textSearch.setText("Ничего не найдено!"); }
                else User.addChoiceInterval(findList, bookArrayList, JListBook);
            } else if (checkboxMagazine.getState()) {
                findList = User.searchText(magazineArrayList, textSearch);
                if (findList.isEmpty()) { textSearch.setText("Ничего не найдено!"); }
                else User.addChoiceInterval(findList, magazineArrayList, JListMagazine);
            } else {
                System.out.println("Ничего не выбрано!");
            }
        }
    };
}