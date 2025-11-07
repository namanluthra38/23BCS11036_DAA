import java.util.Objects;

public class NodeDeg implements Comparable<NodeDeg> {
    int sat;
    int deg;
    int u;

    public NodeDeg(int sat, int deg, int u) {
        this.sat = sat;
        this.deg = deg;
        this.u = u;
    }

    @Override
    public int compareTo(NodeDeg o) {
        // Higher saturation first
        if (this.sat != o.sat) {
            return Integer.compare(o.sat, this.sat);
        }
        // Then higher degree first
        if (this.deg != o.deg) {
            return Integer.compare(o.deg, this.deg);
        }
        // Then smaller vertex id first
        return Integer.compare(this.u, o.u);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NodeDeg other)) return false;
        return this.u == other.u && this.sat == other.sat && this.deg == other.deg;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sat, deg, u);
    }
}

