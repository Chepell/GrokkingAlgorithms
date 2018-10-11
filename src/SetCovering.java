import java.util.*;

public class SetCovering {

    public static void main(String[] args) {
        // множество всех штатов для вещания
        Set<String> statesNeeded = new HashSet<>(Arrays
                .asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        // мэп станций, где value это множество штатов в котором станция вещает
        Map<String, Set<String>> stations = new LinkedHashMap<>();
        // добавляю пары название станции - множество штатов вещания в мэп
        stations.put("kone", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("ktwo", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("kthree", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kfour", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("kfive", new HashSet<>(Arrays.asList("ca", "az")));

        // Переменная под множество в итоге выбранных станция
        Set<String> finalStations = new HashSet<>();
        // цикл продолжается пока во множестве штатов еще есть элементы
        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            Set<String> statesCovered = new HashSet<>(); // множество уже покрытых штатов

            // итерирусь по мэпу станций
            for (Map.Entry<String, Set<String>> station : stations.entrySet()) {
                // множество штатов на которых вещает текущая станция
                Set<String> setOfStatesForCurrentStation = station.getValue();
                // копия множества всех станций для трансляции во временную переменную
                Set<String> covered = new HashSet<>(statesNeeded);
                // метод пересечения, оставляет в множестве covered, только штаты которые также есть и в текущей станции
                covered.retainAll(setOfStatesForCurrentStation);

                // если в covered больше элементов чем в statesCovered
                if (covered.size() > statesCovered.size()) {
                    bestStation = station.getKey(); // сохраняю название текущей станции
                    statesCovered = covered; // обновляю statesCovered
                }
                statesNeeded.removeIf(statesCovered::contains); // из общего множества штатов удаляю те,
                // которые уже есть в списке покрытых

                // если на текущем круге цикла была найдена подходящая станция, то добавляю ее название в список станций
                if (bestStation != null) {
                    finalStations.add(bestStation);
                }
            }
        }
        System.out.println(finalStations);
    }
}
