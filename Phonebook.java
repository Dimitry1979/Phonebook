import java.util.*;

public class ТелефоннаяКнига {

    public static void main(String[] args) {
        // Создаем HashMap для хранения записей телефонной книги
        HashMap<String, HashSet<String>> телефоннаяКнига = new HashMap<>();

        // Добавляем записи в телефонную книгу
        телефоннаяКнига.put("Иван", new HashSet<>(Arrays.asList("+79991234567", "+79876543210")));
        телефоннаяКнига.put("Мария", new HashSet<>(Arrays.asList("+79123456789", "+79087654321")));
        телефоннаяКнига.put("Сергей", new HashSet<>(Collections.singletonList("+79345678901")));
        телефоннаяКнига.put("Мария", new HashSet<>(Arrays.asList("+79876543212")));

        // Сортируем телефонную книгу по убыванию количества телефонов
        Map<String, HashSet<String>> отсортированнаяТелефоннаяКнига = sortByCountPhones(телефоннаяКнига);

        // Выводим отсортированную телефонную книгу
        for (Map.Entry<String, HashSet<String>> запись : отсортированнаяТелефоннаяКнига.entrySet()) {
            System.out.println(запись.getKey() + ": " + запись.getValue());
        }
    }

    // Функция сортировки телефонной книги по убыванию количества телефонов
    private static Map<String, HashSet<String>> sortByCountPhones(Map<String, HashSet<String>> телефоннаяКнига) {
        // Создаем TreeMap для сортировки по ключу (имени)
        TreeMap<String, HashSet<String>> отсортированнаяТелефоннаяКнига = new TreeMap<>(Comparator.reverseOrder());

        // Добавляем записи в TreeMap, подсчитывая количество телефонов
        for (Map.Entry<String, HashSet<String>> запись : телефоннаяКнига.entrySet()) {
            String имя = запись.getKey();
            HashSet<String> телефоны = запись.getValue();

            // Подсчитываем количество телефонов
            int количествоТелефонов = телефоны.size();

            // Добавляем запись в TreeMap, если она еще не существует
            if (!отсортированнаяТелефоннаяКнига.containsKey(имя)) {
                отсортированнаяТелефоннаяКнига.put(имя, new HashSet<>());
            }

            // Добавляем телефоны в HashSet для данной записи
            отсортированнаяТелефоннаяКнига.get(имя).addAll(телефоны);
        }

        return отсортированнаяТелефоннаяКнига;
    }
}