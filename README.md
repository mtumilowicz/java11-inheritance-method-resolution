[![Build Status](https://travis-ci.com/mtumilowicz/java11-inheritance-method-resolution.svg?branch=master)](https://travis-ci.com/mtumilowicz/java11-inheritance-method-resolution)

# java11-inheritance-method-resolution
_Reference_: https://www.amazon.com/Modern-Java-Action-functional-programming/dp/1617293563  
_Reference_: https://github.com/mtumilowicz/java11-default-methods-conflicts
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
1. otherwise - class has to `@Override` method
    * hierarchy
        ```
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
        
        class Clazz implements Interface1, Interface2 {
        
            @Override
            public String introduce() {
                return "Clazz";
            }
        }
        ```
    * tests
        ```
        assertThat(new Clazz().introduce(), is("Clazz"));
        ```
    * It is worth knowing that it is possible to explicitly call
    default method from enclosing interface: 
    https://github.com/mtumilowicz/java11-invoking-default-method  