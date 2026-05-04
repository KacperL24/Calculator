import org.Kacper.*;
import org.junit.*;

public class TreeTesting {

    @Test
    public void testTree() {
        BinaryTree tree = new BinaryTree("1+1");
        Assert.assertNotNull(tree);
    }

    @Test
    public void testSolve() {
        BinaryTree tree = new BinaryTree("1+1");
        Float result = tree.solve();
        Assert.assertEquals(2, result.intValue());
    }

    @Test
    public void testSolve2() {
        BinaryTree tree = new BinaryTree("1+5-12/6");
        Float result = tree.solve();
        Assert.assertEquals(4, result.intValue());
    }

    @Test
    public void testSolve3() {
        BinaryTree tree = new BinaryTree("1/3");
        Float result = tree.solve();
        Assert.assertEquals( 1/3f, result, 0.001f);
    }

    @Test
    public void testSolve4() {
        BinaryTree tree = new BinaryTree("4*3-3");
        Float result = tree.solve();
        Assert.assertEquals( 9, result, 0);
    }

    @Test
    public void testSolve5() {
        BinaryTree tree = new BinaryTree("12");
        Float result = tree.solve();
        Assert.assertEquals( 12, result, 0);
    }
}
