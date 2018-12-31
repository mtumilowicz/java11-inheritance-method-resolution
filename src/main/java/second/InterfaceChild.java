package second;

/**
 * Created by mtumilowicz on 2018-12-31.
 */
interface InterfaceChild extends InterfaceParent {
    default String introduce() {
        return "InterfaceChild";
    }
}
