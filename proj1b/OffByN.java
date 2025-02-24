public class OffByN implements CharacterComparator{
    private final int n;
    public OffByN(int n) {
        this.n = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        return diff == this.n;
    }
}
