package component;

import org.jetbrains.annotations.NotNull;

public class CPosition implements Component {

    public final Integer x;

    public final Integer y;

    public CPosition(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format(simpleName() + "{x=%d, y=%d}", x, y);
    }

    @NotNull
    @Override
    public String simpleName() {
        return "Position";
    }
}
