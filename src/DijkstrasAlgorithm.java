import java.util.*;
import java.util.stream.Collectors;

public class DijkstrasAlgorithm {
    private static Map<String, Map<String, Double>> graph = new HashMap<>();
    // список уже проверенных узлов графа
    private static List<String> processed = new ArrayList<>();

    // метод ищет в мэпе запись с минимальный value и возвращает его key
    private static String findLowestCostNode(Map<String, Double> costs) {
        Double lowestCost = Double.POSITIVE_INFINITY; // переменная для хранения для храннения значения ребра
        String lowestCostNode = null; // перменная под имя узла с минимальной стоимостью
        // проход по всем узлам мэпа со стоимостью
        for (Map.Entry<String, Double> node : costs.entrySet()) {
            Double cost = node.getValue(); // значение текущего ребра
            String nodeStr = node.getKey();
            // если найден новый узел с меньшим значением ребра и такого узла еще нет в списке проверенных
            if (cost < lowestCost && !processed.contains(nodeStr)) {
                lowestCost = cost;
                lowestCostNode = nodeStr;
            }
        }
        return lowestCostNode; // после порохода всего мэпа, возвращаю значение key с минимальным ребром
    }

    public static void main(String[] args) {
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6.0);
        graph.get("start").put("b", 2.0);

        graph.put("a", new HashMap<>());
        graph.get("a").put("end", 1.0);

        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3.0);
        graph.get("b").put("end", 5.0);

        graph.put("end", new HashMap<>());

        Map<String, Double> costs = new HashMap<>();
        costs.put("a", 6.0);
        costs.put("b", 2.0);
        costs.put("end", Double.POSITIVE_INFINITY);

        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("end", null);

        // из мэпа стоимости извелекаю узел у которого ребро минимальное
        String node = findLowestCostNode(costs);

        // пока есть узлы цикл продолжается
        while (node != null) {
            // получаю значение ребра по имени узла
            Double cost = costs.get(node);

            // создается мэп соседей к текущему узлу. фактически получений value по key
            Map<String, Double> neighbors = graph.get(node);
            // цикл по множеству key мэпа
            for (String n : neighbors.keySet()) {
                double newCost = cost + neighbors.get(n); // для текущего соседа определяется полный путь от start
                if (newCost < costs.get(n)) { // и если к этому соседу можно добраться быстрее
                    costs.put(n, newCost); // то перезаписываю пару в мэпе, фактически обновляется значение value
                    parents.put(n, node); // путь пръодит через новый узел, обновляю его родителя.
                }
            }
            processed.add(node); // узел помечается как обработанный
            node = findLowestCostNode(costs); // ищу следующий минимальный узел
        }

        Map<String, Double> sortCosts = costs.entrySet().stream().sorted(Map.Entry
                .comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println("Cost from the start to each node:");
        System.out.println(sortCosts);
    }
}
