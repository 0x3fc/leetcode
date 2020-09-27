package EvaluateDivision;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            String u = equation.get(0);
            String v = equation.get(1);
            double value = values[i];

            putInGraph(graph, u, v, value);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            List<String> query = queries.get(i);
            String u = query.get(0);
            String v = query.get(1);

            res[i] = findResult(graph, u, v, new HashSet<>());
        }
        return res;
    }

    private void putInGraph(Map<String, Map<String, Double>> graph, String u, String v, double value) {
        if (!graph.containsKey(u))
            graph.put(u, new HashMap<>());
        if (!graph.containsKey(v))
            graph.put(v, new HashMap<>());

        graph.get(u).put(v, value);
        graph.get(v).put(u, 1.0 / value);
    }

    private double findResult(Map<String, Map<String, Double>> graph, String u, String v, Set<String> seen) {
        if (!graph.containsKey(u))
            return -1;

        Map<String, Double> node = graph.get(u);

        if (node.containsKey(v))
            return node.get(v);

        for (String chained : node.keySet()) {
            if (seen.contains(chained))
                continue;
            seen.add(chained);
            double chainedResult = findResult(graph, chained, v, seen);
            if (chainedResult != -1)
                return node.get(chained) * chainedResult;
        }

        return -1;
    }

    // Union Find

    public double[] calcEquationUnionFind(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, String> parents = new HashMap<>();
        Map<String, Double> edges = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            String p1 = find(parents, edges, u);
            String p2 = find(parents, edges, v);
            parents.put(p1, p2);
            edges.put(p1, values[i] * edges.get(v) / edges.get(u));
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);
            if (!parents.containsKey(u) || !parents.containsKey(v)) {
                res[i] = -1.0;
                continue;
            }
            String p1 = find(parents, edges, u);
            String p2 = find(parents, edges, v);
            res[i] = p1.equals(p2) ? edges.get(u) / edges.get(v) : -1.0;
        }

        return res;
    }

    private String find(Map<String, String> parents, Map<String, Double> edges, String n) {
        if (!parents.containsKey(n)) {
            parents.put(n, n);
            edges.put(n, 1.0);
            return n;
        }

        String parent = parents.get(n);
        if (parent.equals(n))
            return n;

        String root = find(parents, edges, parent);
        parents.put(n, root);
        edges.put(n, edges.get(parent) * edges.get(n));

        return root;
    }
}
