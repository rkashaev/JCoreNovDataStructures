package lesson180117;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class SimpleBinaryTree<E extends Comparable<E>> {
    Node<E> root;

    public void add(E value) {
        root = createOrAdd(root, value);
    }

    public boolean remove(E value) {
        return false;
    }

    private <X extends Comparable<X>> Node<X> createOrAdd(Node<X> node, X value) {
        if (node == null) {
            node = new Node<>(value);
        } else {
            node.add(value);
        }
        return node;
    }

    class Node<T extends Comparable<T>> {
        T value;
        Node<T> left = null;
        Node<T> right = null;

        public Node(T value) {
            this.value = value;
        }

        void add(T value) {
            if (this.value.compareTo(value) > 0) {
                left = createOrAdd(left, value);
            } else {
                right = createOrAdd(right, value);
            }
        }

    }

    private class BFIterator implements Iterator<E> {
        Queue<Node<E>> queue = new LinkedList<>();

        public BFIterator() {
            queue.offer(root);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public E next() {
            Node<E> cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            return cur.value;
        }
    }

//    private class DFIterator implements Iterator<E> {
//        Node<E> cur = root;
//
//
//        @Override
//        public boolean hasNext() {
//            //return
//        }
//
//        @Override
//        public E next() {
//
//        }
//    }

    public Iterable<E> bfIterator() {
        return new Iterable<E>() {
            @Override
            public Iterator<E> iterator() {
                return new BFIterator();
            }
        };
    }

    public Iterable<E> dfIterator() {
        return new Iterable<E>() {
            @Override
            public Iterator<E> iterator() {
//                return new DFIterator();
                return null;
            }
        };
    }

    public void printDepthFirst() {
        stepIn(root);
    }

    private void stepIn(Node<E> node) {
        if (node == null) {
            return;
        }
        // pre-order
        System.out.println(node.value);
        stepIn(node.left);
        stepIn(node.right);

        // in-order
//        stepIn(node.left);
//        System.out.println(node.value);
//        stepIn(node.right);

        // post-order
    }




    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 3, 8, 5, 2, 1, 10);

        SimpleBinaryTree<Integer> tree = new SimpleBinaryTree<>();

        for (Integer el : list) {
            tree.add(el);
        }

        // breadth-first
        for (Integer el : tree.bfIterator()) {
            System.out.println(el);
        }

        System.out.println();

        tree.printDepthFirst();

        Path p = Paths.get("sdfsdf");
    }
}
