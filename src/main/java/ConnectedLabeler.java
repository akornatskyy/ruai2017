import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A connected component labeler.
 *
 * See https://en.wikipedia.org/wiki/Connected-component_labeling
 */
public final class ConnectedLabeler<T> {

  private final ListTileTranslator<T> translator;

  public ConnectedLabeler(
      Function<T, Double> xf,
      Function<T, Double> yf,
      int tileSize) {
    translator = new ListTileTranslator<>(t -> new Tile<>(
        (int) Math.floor(xf.apply(t) / tileSize),
        (int) Math.floor(yf.apply(t) / tileSize)));
  }

  public List<List<T>> grouped(Collection<T> units) {
    return list(translator.from(units)).stream()
        .map(c -> c.tiles.stream()
            .flatMap(t -> t.units.stream())
            .collect(Collectors.toList()))
        .collect(Collectors.toList());
  }

  private static <T> Collection<Connected<T>> list(Collection<Tile<T>> tiles) {
    Collection<Connected<T>> result = new ArrayList<>();
    tiles.forEach(tile -> tile.neighbours()
        .stream()
        .map(neighbor -> result.stream()
            .filter(t -> t.tiles.contains(neighbor))
            .findFirst()
            .orElse(null))
        .filter(Objects::nonNull)
        .reduce((current, found) -> {
          if (current != found) {
            current.tiles.addAll(found.tiles);
            result.remove(found);
          }

          return current;
        })
        .orElseGet(() -> {
          Connected<T> connected = new Connected<>();
          result.add(connected);
          return connected;
        })
        .tiles.add(tile));
    return result;
  }

  private static class Tile<T> {
    final int x;
    final int y;

    List<T> units;

    @SuppressWarnings("checkstyle:parametername")
    Tile(int x, int y) {
      this.x = x;
      this.y = y;
    }

    List<Tile> neighbours() {
      return Arrays.asList(
          new Tile(x + 1, y),
          new Tile(x + 1, y + 1),
          new Tile(x, y + 1),
          new Tile(x - 1, y + 1),
          new Tile(x - 1, y),
          new Tile(x - 1, y - 1),
          new Tile(x, y - 1),
          new Tile(x + 1, y - 1)
      );
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Tile tile = (Tile) o;
      return tile.x == x && tile.y == y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    @Override
    public String toString() {
      return "(" + x + ", " + y + "):" + units;
    }
  }

  private static class ListTileTranslator<T> {

    private final Function<T, Tile<T>> translator;

    public ListTileTranslator(Function<T, Tile<T>> translator) {
      this.translator = translator;
    }

    Collection<Tile<T>> from(Collection<T> units) {
      List<Tile<T>> tiles = new ArrayList<>();
      units.forEach(t -> {
        Tile<T> tile = translator.apply(t);
        int i = tiles.indexOf(tile);
        if (i >= 0) {
          tile = tiles.get(i);
        } else {
          tiles.add(tile);
          tile.units = new ArrayList<>();
        }

        tile.units.add(t);
      });
      return tiles;
    }
  }

  private static class Connected<T> {
    final List<Tile<T>> tiles = new ArrayList<>();

    @Override
    public String toString() {
      return tiles.toString();
    }
  }
}