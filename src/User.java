import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/*
Разработать приложение, обеспечивающее поиск в двух раскрывающихся
списках (Choice) фрагмента текста. Набором флажков (CheckboxGroup)
указывать, в каком списке будет осуществляться поиск. Строки,
в которых будет найден искомый фрагмент, должны быть выделены
(предполагается, что несколько строк может иметь искомый фрагмент).
Помимо этого приложение должно обеспечивать управление содержимым
списков – добавление нового элемента, редактирование, удаление.
 */
public class User
{
    public static void main(String[] args) {
        Panel testPanel = new Panel();
        testPanel.setVisible(true);
    }
    public static List<String> searchText(List<String> gettedList, JTextField textSearch) {
        String keyword = textSearch.getText();
        List<String> findList = new ArrayList<>();
        for (String item : gettedList) {
            if (item.contains(keyword)) {
                findList.add(item);
            }
        }
        return findList;
    }
    public static void addChoiceInterval(List<String> findList, List<String> gettedList, JList<String> JListGetted) {
        for (int i = 0; i < gettedList.size(); i++){
            String item = gettedList.get(i);
            if (findList.contains(item)) {
                JListGetted.addSelectionInterval(i, i);
            }
        }
    }
}
