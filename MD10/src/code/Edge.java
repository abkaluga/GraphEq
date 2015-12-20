package code;

public class Edge {

    private Integer begin, end;

    public Edge(int begin, int end) {
        super();
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[').append(begin).append(',').append(end).append(']');
        return builder.toString();
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
