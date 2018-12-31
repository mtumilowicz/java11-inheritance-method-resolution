# java11-inheritance-method-resolution
_Reference_: https://www.amazon.com/Modern-Java-Action-functional-programming/dp/1617293563  

# resolution rules
1. classes always win, package: **first**
    * hierarchy
        ```
        class Child extends Parent implements Interface1 {
        }
        
        interface Interface1 {
            default String introduce() {
                return "Interface1";
            }
        }
        
        interface Interface2 {
            default String introduce() {
                return "Interface2";
            }
        }
        
        class Parent implements Interface2 {
            public String introduce() {
                return "Parent";
            }
        }
        ```
    * tests
        ```
        assertThat(new Child().introduce(), is("Parent"));
        ```
1. otherwise, most specific interface wins
    * hierarchy
        ```
        class Clazz implements InterfaceParent, InterfaceChild {
        }
        
        interface InterfaceChild extends InterfaceParent {
            default String introduce() {
                return "InterfaceChild";
            }
        }
        
        interface InterfaceParent {
            default String introduce() {
                return "InterfaceParent";
            }
        }
        ```
    * tests
        ```
        assertThat(new Clazz().introduce(), is("InterfaceChild"));
        ```
1. otherwise - class has to explicitly select method

    it is covered in my other github repos:
    * https://github.com/mtumilowicz/java11-invoking-default-method  
    * https://github.com/mtumilowicz/java11-default-methods-conflicts