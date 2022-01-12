package stackqueue;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * An animal shelter, which holds only dogs and cats, operates on a strictly
 * "first in, first out" basis.
 * People must adopt either the "oldest" (based on arrival time) of all animals
 * at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive
 * the oldest animal of that type).
 * They cannot select which specific animal they would like.
 * <p>
 * Create the data structures to maintain this system and implement operations
 * such as
 * enqueue, dequeueAny, dequeueDog, and dequeueCat.
 * <p>
 * You may use the built-in Linked list data structure.
 */
class _03_06_AnimalShelter {

    private ArrayList<Animal> dogs;
    private ArrayList<Animal> cats;
    private int ctr;

    _03_06_AnimalShelter() {
        dogs = new ArrayList<Animal>();
        cats = new ArrayList<Animal>();
        ctr = 0;
    }

    void enqueueDog(int num) {
        Animal pup = new Animal(num, ++ctr);
        dogs.add(pup);
    }

    void enqueueCat(int num) {
        Animal gato = new Animal(num, ++ctr);
        cats.add(gato);
    }

    int dequeueAny() {
        Animal pupper, gato;
        if (dogs.size() > 0) {
            pupper = dogs.get(0);
        } else {
            pupper = new Animal(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        if (cats.size() > 0) {
            gato = cats.get(0);
        } else {
            gato = new Animal(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        if (pupper.name == Integer.MAX_VALUE && gato.name == Integer.MAX_VALUE) {
            throw new EmptyStackException();
        }

        if (pupper.counter < gato.counter) {
            dogs.remove(0);
            return pupper.name;
        } else {
            cats.remove(0);
            return gato.name;
        }

    }

    int dequeueDog() {
        if (dogs.size() <= 0) {
            throw new EmptyStackException();
        }

        return dogs.remove(0).name;
    }

    int dequeueCat() {
        if (cats.size() <= 0) {
            throw new EmptyStackException();
        }

        return cats.remove(0).name;
    }

    public static void main(String[] args) {
        _03_06_AnimalShelter s = new _03_06_AnimalShelter();
        s.enqueueCat(5);
        s.enqueueDog(4);
        s.enqueueCat(6);
        s.enqueueCat(7);
        System.out.println(s.dequeueAny());
        System.out.println(s.dequeueAny());

        System.out.println(s.dequeueAny());
        System.out.println(s.dequeueAny());

    }

    static class Animal {
        int name;
        int counter;

        Animal(int name, int counter) {
            this.name = name;
            this.counter = counter;
        }
    }
}
