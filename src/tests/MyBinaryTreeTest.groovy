package tests

import All.MyBinaryTree
import org.junit.Test

import static org.junit.Assert.assertEquals;


/**
 * Created by Alexandr on 30.03.2016.
 */
class MyBinaryTreeTest  {

    @Test
    void WhenCurrentLeftIsnullRemove() {
         MyBinaryTree<Integer> a = new MyBinaryTree<>()
         a.add(14);
         a.add(16);
         assertEquals(true,a.remove(14))

    }

    @Test
    void WhenRightIsnullRemove() {
        MyBinaryTree<Integer> a = new MyBinaryTree<>()
        a.add(12)
        a.add(14);
        a.add(13);
        assertEquals(true,a.remove(14))
    }


}
