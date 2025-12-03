package task1;

import java.util.*;

class NodeData {
    String name;
    List<Connection> connections;

    public NodeData(String name) {
        this.name = name;
        this.connections = new ArrayList<>();
    }

    public void addConnection(Connection connection) {
        this.connections.add(connection);
    }
}

class Connection {
    NodeData destination;
    int capacity;
    int packageLoss;

    public Connection(NodeData destination, int capacity, int packageLoss) {
        this.destination = destination;
        this.capacity = capacity;
        this.packageLoss = packageLoss;
    }
}

class Schema {
    Map<String, NodeData> schema;

    public Schema() {
        this.schema = new HashMap<>();
    }

    public void addNode(String name) {
        schema.put(name, new NodeData(name));
    }

    public void addConnection(String from, String to, int capacity, int packageLoss) {
        NodeData fromNode = schema.get(from);
        NodeData toNode = schema.get(to);

        Connection connection = new Connection(toNode, capacity, packageLoss);
        Connection reverseConnection = new Connection(fromNode, capacity, packageLoss);

        fromNode.addConnection(connection);
        toNode.addConnection(reverseConnection);
    }

    public void printSchema() {
        for (NodeData node : schema.values()) {
            System.out.println("Node: " + node.name + " is connected to:");

            for (Connection connection : node.connections) {
                System.out.println(connection.destination.name + " [capacity: " + connection.capacity + ", packageLoss: " + connection.packageLoss + "%]");
            }
        }
    }
}

public class NodeImplementation {
    public static void main(String[] args) {
        Schema schema = new Schema();

        schema.addNode("A");
        schema.addNode("B");
        schema.addNode("C");
        schema.addNode("D");
        schema.addNode("E");
        schema.addNode("F");

        schema.addConnection("A", "B", 1500, 90);
        schema.addConnection("A", "C", 2000, 10);
        schema.addConnection("A", "D", 1000, 50);
        schema.addConnection("B", "F", 1500, 60);
        schema.addConnection("C", "F", 500, 20);
        schema.addConnection("C", "E", 900, 5);
        schema.addConnection("D", "E", 2500, 1);
        schema.addConnection("E", "F", 300, 85);

        schema.printSchema();
    }
}
