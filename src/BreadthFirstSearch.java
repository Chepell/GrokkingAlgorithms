import java.util.*;

public class BreadthFirstSearch {
    // граф ввиде мэпа
    private static Map<Friend, List<Friend>> graph = new HashMap<>();

    private static boolean search(Friend friend) {
        // лист value для key friend помещаю в объект очереди
        Queue<Friend> searchQueue = new ArrayDeque<>(graph.get(friend));
        List<Friend> checked = new ArrayList<>(); // создаю список, в который буду добавлять уже проверенных Friend
        checked.add(friend); // сразу добавляю текущий объект, т.к. его не нужно проверять, с него начинаем поиск
        // цикл продолжается, пока в очереди есть элементы
        while (!searchQueue.isEmpty()) {
            Friend person = searchQueue.poll(); // достаю объект из очереди
            if (!checked.contains(person)) { // проверяю нет ли объекта в списке уже проверенных
                if (person.isSeller()) { // если объект продавец
                    System.out.println(person.getName() + " is a mango seller!"); // то возвращаю сообщение
                    return true; // и выхожу из метода возвращая true
                } else { // если объект не продавец
                    List<Friend> friendList = graph.get(person); // достаю его value из map
                    if (!friendList.isEmpty()) { // проверяю, что список не пустой
                        searchQueue.addAll(friendList); // тогда добавляю весь список в конец очереди
                    }
                    checked.add(person); // а сам текущий объект добавляю в список уже проверенных объектов
                }
            }
        }
        // если сюда вышли из цикла while, то значит не нашли в графе ни одного продавца
        System.out.println("Seller is not found!");
        return false;
    }


    public static void main(String[] args) {
        Friend artem = new Friend("Artem", false);
        Friend dima = new Friend("Dima", false);
        Friend andrey = new Friend("Andrey", false);
        Friend viktor = new Friend("Viktor", true);
        Friend alex = new Friend("Alex", false);
        Friend olga = new Friend("Olga", false);
        Friend ruslan = new Friend("Ruslan", true);

        ArrayList<Friend> artemList = new ArrayList<>();
        artemList.add(dima);
        artemList.add(olga);
        artemList.add(viktor);
        artemList.add(andrey);

        ArrayList<Friend> dimaList = new ArrayList<>();
        dimaList.add(artem);
        dimaList.add(viktor);
        dimaList.add(olga);
        dimaList.add(andrey);
        dimaList.add(alex);

        ArrayList<Friend> olgaList = new ArrayList<>();
        olgaList.add(artem);
        olgaList.add(viktor);
        olgaList.add(dima);

        ArrayList<Friend> andreyList = new ArrayList<>();
        andreyList.add(artem);
        andreyList.add(dima);
        andreyList.add(alex);

        ArrayList<Friend> viktorList = new ArrayList<>();
        viktorList.add(olga);

        ArrayList<Friend> alexList = new ArrayList<>();
        alexList.add(dima);
        alexList.add(andrey);
        alexList.add(ruslan);

        ArrayList<Friend> ruslanList = new ArrayList<>();

        graph.put(artem, artemList);
        graph.put(dima, dimaList);
        graph.put(viktor, viktorList);
        graph.put(olga, olgaList);
        graph.put(andrey, andreyList);
        graph.put(alex, alexList);
        graph.put(ruslan, ruslanList);

        search(artem);

    }
}
