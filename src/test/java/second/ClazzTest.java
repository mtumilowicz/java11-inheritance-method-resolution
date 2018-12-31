package second;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by mtumilowicz on 2018-12-31.
 */
public class ClazzTest {

    @Test
    public void from_most_specific_interface() {
        assertThat(new Clazz().introduce(), is("InterfaceChild"));
    }
}