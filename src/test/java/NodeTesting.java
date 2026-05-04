import org.Kacper.*;
import org.junit.*;

public class NodeTesting {

    @Test
    public void testNode() {
        Node<Integer> node = new Node<>(1, "Number");
        Assert.assertNotNull(node);
    }

    @Test
    public void testType() {
        Node<Integer> node = new Node<>(1, "Number");
        Assert.assertEquals("Number", node.getType());
    }

    @Test
    public void testElement() {
        Node<Character> node = new Node<>('+', "Operator");
        Assert.assertEquals('+', (char) node.getElement());
    }

    @Test
    public void testLeft() {
        Node<Character> opNode = new Node<>('-', "Operator");
        Node<Integer> numNode = new Node<>(7, "Number");
        opNode.setLeft(numNode);

        Assert.assertEquals(7, opNode.goLeft().getElement());
    }

    @Test
    public void testRight() {
        Node<Character> opNode = new Node<>('-', "Operator");
        Node<Integer> numNode = new Node<>(7, "Number");
        opNode.setRight(numNode);

        Assert.assertEquals(7, opNode.goRight().getElement());
    }
}
