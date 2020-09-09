package ListImpl;

public class FavoritesList<E> {
    PositionalList<Item<E>> list = new LinkedPositionalList<>();

    public FavoritesList() {
    }

    protected E value(Position<Item<E>> p){
        return p.getElement().getValue();
    }

    protected int count(Position<Item<E>> p){
        return p.getElement().getCount();
    }

    protected Position<Item<E>> findPosition(E e){
        Position<Item<E>> walk = list.first();
        while(walk != list.last()){
            if(walk.getElement().getValue() == e){
                return walk;
            }
            walk = list.after(walk);
        }
        return null;
    }
    //Move item earlier in the list based on access count
    protected void moveUp(Position<Item<E>> p){
        int count = count(p);
        Position<Item<E>> walk = p;
        while(walk != list.first() && count(list.before(walk)) < count){
            walk = list.before(walk);
        }
        if(walk != p){
            list.addBefore(walk, list.remove(p));
        }
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    //Access element e (may be new) and increase the access count.
    public void access(E e){
        Position<Item<E>> p = findPosition(e);
        if(p == null){
            p = list.addLast(new Item<E>(e));
        }
        p.getElement().setCount(p.getElement().getCount() + 1);
        moveUp(p);
    }

    public void remove(E e){
        Position<Item<E>> p = findPosition(e);
        if(p != null)
        {
            list.remove(p);
        }
    }

    public Iterable<E> getFavorites(int k) throws IllegalArgumentException {
        if(k < 0 || k > size()){
            throw new IllegalArgumentException("Invalid K provided.");
        }
        PositionalList<E> results = new LinkedPositionalList<>();
        Iterator<Item<E>> it = list.iterator();

        for(int i = 0; i < k; i++){
            results.addLast(it.next().getValue());
        }
        return results;
    }

    protected static class Item<E> {
        private E value;
        private int count = 0;

        public Item(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
