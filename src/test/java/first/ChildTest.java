package first;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by mtumilowicz on 2018-12-31.
 */
public class ChildTest {
    
    @Test
    public void introduce_fromParent() {
        assertThat(new Child().introduce(), is("Parent"));
    }

}