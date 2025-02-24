import java.util.*;

public class Graph
{
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
    private Map<String, String> attributes;

    public Graph()
    {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.attributes = new HashMap<>();
    }

    public Graph(Map<String, String> attributes)
    {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.attributes = attributes;
    }

    public Collection<Node> getNodes()
    {
        return nodes;
    }

    public Collection<Edge> getEdges()
    {
        return edges;
    }

    public Graph node(String name)
    {
        this.nodes.add(new Node(name));
        return this;
    }

    public Graph node(String name, Map<String, String> attributes)
    {
        this.nodes.add(new Node(name, attributes));
        return this;
    }

    public Graph edge(String start, String end)
    {
        this.edges.add(new Edge(start, end));
        return this;
    }

    public Graph edge(String start, String end, Map<String, String> attributes)
    {
        this.edges.add(new Edge(start, end, attributes));
        return this;
    }

    public Map<String, String> getAttributes()
    {
        return attributes;
    }
}
