
/**
 * global vs local
 * function scope and hoisting
 */
    // lo mismo que antes, la variable global scope  no es modificada, ya que la funcion crea su var scope
    // y la modifica. 
 var scope = "global";

function f() {

    var scope;
    console.log(scope);
    scope = "local";
    console.log(scope);
}

f();

console.log(scope);