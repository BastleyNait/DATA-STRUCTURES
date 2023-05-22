import java.util.*;

public class MiLista<E> implements List<E> {
    private ArrayList<E> lista; // Utilizamos un ArrayList interno para almacenar los elementos de la lista

    public MiLista() {
        lista = new ArrayList<>(); // Inicializamos el ArrayList en el constructor
    }

    @Override
    public int size() {
        return lista.size(); // Devuelve el tamaño de la lista utilizando el tamaño del ArrayList interno
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty(); // Verifica si la lista está vacía utilizando el método isEmpty() del ArrayList
    }

    @Override
    public boolean contains(Object o) {
        return lista.contains(o); // Verifica si la lista contiene un elemento específico utilizando el método contains() del ArrayList
    }

    @Override
    public boolean add(E e) {
        return lista.add(e); // Agrega un elemento a la lista utilizando el método add() del ArrayList
    }

    @Override
    public boolean remove(Object o) {
        return lista.remove(o); // Elimina un elemento de la lista utilizando el método remove() del ArrayList
    }
    //Hay algunos metodos que son abstactos que el IDE me obligaba a importar
    //A eso se debe que no contengan nada
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        lista.clear(); // Elimina todos los elementos de la lista utilizando el método clear() del ArrayList
    }

    @Override
    public E get(int index) {
        return lista.get(index); // Obtiene el elemento en la posición especificada utilizando el método get() del ArrayList
    }

    @Override
    public E set(int index, E element) {
        return lista.set(index, element); // Reemplaza el elemento en la posición especificada con el nuevo elemento utilizando el método set() del ArrayList
    }

    @Override
    public void add(int index, E element) {
        lista.add(index, element); // Inserta un elemento en la posición especificada utilizando el método add() del ArrayList
    }

    @Override
    public E remove(int index) {
        return lista.remove(index); // Elimina y devuelve el elemento en la posición especificada utilizando el método remove() del ArrayList
    }

    @Override
    public int indexOf(Object o) {
        return lista.indexOf(o); // Devuelve el índice de la primera aparición del elemento especificado utilizando el método indexOf() del ArrayList
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    // Otros métodos de la interfaz List se pueden implementar de manera similar

    @Override
    public Iterator<E> iterator() {
        return lista.iterator(); // Devuelve un iterador para recorrer los elementos de la lista utilizando el método iterator() del ArrayList
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }
}
