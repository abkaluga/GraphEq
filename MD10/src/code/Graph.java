package code;

import java.math.BigInteger;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Graph {

    Integer verticles;
    List<Edge> edges;

    public Graph(List<Edge> edges, Integer verticles) {
        super();
        this.edges = edges;
        this.verticles = verticles;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Integer getVerticlesSize() {
        return verticles;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        StringBuffer builder = new StringBuffer();

        edges.parallelStream().forEach((edge) -> builder.append(edge.toString()));

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Graph)) {
            return false;
        }
        Graph s = (Graph) o;

        if (s.verticles != this.verticles) {
            return false;
        }

        BigInteger[] compare = preparaTable();
        Set<Edge> set = new LinkedHashSet<Edge>(this.getEdges());
        for (Edge edge : set) {
            compare[edge.getBegin()] = compare[edge.getBegin()].setBit(edge.getEnd());
            compare[edge.getEnd()] = compare[edge.getEnd()].setBit(edge.getBegin());
        }

        set = new LinkedHashSet<Edge>(s.getEdges());
        for (Edge edge : set) {
            if (compare[edge.getBegin()].testBit(edge.getEnd())//
                    && compare[edge.getEnd()].testBit(edge.getBegin())) {
                compare[edge.getBegin()] = compare[edge.getBegin()].clearBit(edge.getEnd());
                compare[edge.getEnd()] = compare[edge.getEnd()].clearBit(edge.getBegin());
            } else {
                return false;
            }
        }

        for (int i = 0; i < compare.length; ++i) {
            if (!compare[i].equals(BigInteger.ZERO)) {
                return false;

            }
        }

        return true;

    }

    private BigInteger[] preparaTable() {
        BigInteger[] compare = new BigInteger[this.verticles];

        for (int i = 0; i < compare.length; ++i) {
            compare[i] = new BigInteger("0");
        }
        return compare;
    }
}
