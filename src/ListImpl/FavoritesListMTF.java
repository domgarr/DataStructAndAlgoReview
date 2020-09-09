package ListImpl;

import sun.awt.image.ImageWatched;

public class FavoritesListMTF<E> extends FavoritesList<E> {
    @Override
    protected void moveUp(Position<Item<E>> p) {
        if(p != list.first()){
            list.addFirst(list.remove(p));
        }
    }

    @Override
    public Iterable<E> getFavorites(int k) throws IllegalArgumentException {
        if(k < 0 || k > size()){
            throw new IllegalArgumentException("Invalid k.");
        }

        PositionalList<Item<E>> temp = new LinkedPositionalList<>();

        Iterator<Item<E>> it = list.iterator();
        while(it.hasNext()){
            temp.addLast(it.next());
        }

        PositionalList<E> result = new LinkedPositionalList<>();

        for(int i = 0; i < k ; i++){
            Position<Item<E>> highPos = temp.first();
            Position<Item<E>> walk = temp.after(highPos);

            while(walk != null){
                if(count(walk) > count(highPos)){
                    highPos = walk;
                }
                walk = list.after(walk);
            }
            result.addLast(value(highPos));
            temp.remove(highPos);
        }
        return result;
    }
}
