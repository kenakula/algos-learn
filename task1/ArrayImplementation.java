package task1;

import java.util.*;

class ArrayNode {
    String name;
    Map<String, int[]> connections;

    public ArrayNode(String name, Map<String, int[]> connections) {
        this.name = name;
        this.connections = connections;
    }
}

public class ArrayImplementation {
    static int[] pathAB = new int[]{1500, 90};
    static int[] pathAC = new int[]{2000, 10};
    static int[] pathAD = new int[]{1000, 50};
    static int[] pathBF = new int[]{1500, 60};
    static int[] pathCF = new int[]{500, 20};
    static int[] pathCE = new int[]{900, 5};
    static int[] pathDE = new int[]{2500, 1};
    static int[] pathEF = new int[]{300, 85};

    public static void main(String[] args) {
        List<ArrayNode> dataList = new ArrayList<>();

        Map<String, int[]> mapA = new HashMap<>();
        mapA.put("B", pathAB);
        mapA.put("C", pathAC);
        mapA.put("D", pathAD);
        dataList.add(new ArrayNode("A", mapA));

        Map<String, int[]> mapB = new HashMap<>();
        mapB.put("A", pathAB);
        mapB.put("F", pathBF);
        dataList.add(new ArrayNode("B", mapB));

        Map<String, int[]> mapC = new HashMap<>();
        mapC.put("A", pathAC);
        mapC.put("F", pathCF);
        mapC.put("E", pathCE);
        dataList.add(new ArrayNode("C", mapC));

        Map<String, int[]> mapD = new HashMap<>();
        mapD.put("A", pathAD);
        mapD.put("E", pathDE);
        dataList.add(new ArrayNode("D", mapD));

        Map<String, int[]> mapE = new HashMap<>();
        mapE.put("D", pathDE);
        mapE.put("F", pathEF);
        mapE.put("C", pathCE);
        dataList.add(new ArrayNode("E", mapE));

        Map<String, int[]> mapF = new HashMap<>();
        mapF.put("E", pathEF);
        mapF.put("C", pathCF);
        mapF.put("B", pathBF);
        dataList.add(new ArrayNode("F", mapF));

        for(ArrayNode node : dataList) {
            String name = node.name; // No casting needed
            Map<String, int[]> map = node.connections; // No casting needed

            System.out.println("Node name: " + name);

            for (Map.Entry<String, int[]> mapEntry : map.entrySet()) {
                String key = mapEntry.getKey();
                int[] values = mapEntry.getValue();
                System.out.println("  -> Connection to node " + key + " [capacity: " + values[0] + ", packagesLoss: " + values[1] + "%]");
            }
        }
    }
}