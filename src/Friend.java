import java.util.Objects;

class Friend {
    private final String name;
    private boolean seller;

    Friend(String name, boolean seller) {
        this.name = name;
        this.seller = seller;
    }


    String getName() {
        return name;
    }

    boolean isSeller() {
        return seller;
    }

    public void setSeller(boolean seller) {
        this.seller = seller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return seller == friend.seller &&
                Objects.equals(name, friend.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, seller);
    }
}
